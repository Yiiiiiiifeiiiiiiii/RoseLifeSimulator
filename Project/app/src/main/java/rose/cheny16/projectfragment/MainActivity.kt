package rose.cheny16.projectfragment

import android.app.AlertDialog
import android.content.Context
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.menudialog.view.*
import rose.cheny16.projectfragment.models.Status
import android.media.AudioManager
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.content.Context.AUDIO_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import com.google.common.io.Flushables.flush
import android.os.Environment.getExternalStorageDirectory
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.util.Log
import android.view.View
import android.widget.ImageView
import java.io.File
import java.io.FileOutputStream
import java.util.*


//class MainActivity : AppCompatActivity(), fragment_mainpage.IgetFt{
class MainActivity : AppCompatActivity(), fragment_mainpage.IgetFt, fragment_login.IgetFt,
    fragment_login.onLoginButtonPressedListener,fragment_saveload.OnFragmentInteractionListener,Status.IgetStatus {
    override fun chooseExit() {
        save()
        finish()

    }


    override fun setStatus(s: Status) {
        this.player = s;
    }

    override fun getStatus(): Status {
        return player
    }




    override fun onFragmentInteraction(uri: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d(Constants.TAG, "in main -> onFragmentInteraction")
        onBackPressed()
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            WRITE_EXTERNAL_STORAGE_PERMISSION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
                    Log.d(Constants.TAG, "Permission granted")
                } else {
                    // permission denied
                }
                return
            }
        }
    }

    private val RC_SIGN_IN = 1
    private val WRITE_EXTERNAL_STORAGE_PERMISSION = 2
    lateinit var authListener: FirebaseAuth.AuthStateListener
    val auth = FirebaseAuth.getInstance()
    var saveLoadFragment: fragment_saveload? = null
    var player = Status()
    private var audioManager: AudioManager? = null
    private var sharePath = "no"


    override fun getFt(): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
    }



    override fun onStart() {
        super.onStart()
        auth.addAuthStateListener(authListener)


    }

    override fun onStop() {
        super.onStop()
        auth.removeAuthStateListener(authListener)
    }

    override fun lauchLoginUI(){
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        val loginIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setLogo(R.drawable.ic_launcher_background)
            .build()

        startActivityForResult(loginIntent, RC_SIGN_IN)

    }

    private fun initializeListeners(){
        authListener = FirebaseAuth.AuthStateListener { auth ->
            val user = auth.currentUser
            if(user != null){
                switchToNext(user.uid)
            }else{
                switchToNext("no id")
            }
        }
    }

    private fun switchToNext(uid: String){
        var ft = supportFragmentManager.beginTransaction()
//        ft.replace(R.id.fragment_container,fragment_login(),"login")
        ft.replace(R.id.fragment_container,fragment_introduction.newInstance(uid),"intro")
        ft.commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        initializeListeners()
        checkPermissions()



    }

    private fun initControls(volumeSeekbar: SeekBar) {
        try {
            audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
            volumeSeekbar.setMax(
                audioManager!!
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            )
            volumeSeekbar.setProgress(
                audioManager!!
                    .getStreamVolume(AudioManager.STREAM_MUSIC)
            )


            volumeSeekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onStopTrackingTouch(arg0: SeekBar) {}

                override fun onStartTrackingTouch(arg0: SeekBar) {}

                override fun onProgressChanged(arg0: SeekBar, progress: Int, arg2: Boolean) {
                    audioManager!!.setStreamVolume(
                        AudioManager.STREAM_MUSIC,
                        progress, 0
                    )
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    private fun checkPermissions() {
        // Check to see if we already have permissions
        if (ContextCompat
                .checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            // If we do not, request them from the user
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                WRITE_EXTERNAL_STORAGE_PERMISSION
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun takeScreenshot() {
        val now = Date()
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)

        try {
            // image naming and path  to include sd card  appending name you choose for file
            val mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpeg"

            // create bitmap screen capture
            val v1 = window.decorView.rootView
            v1.isDrawingCacheEnabled = true
            val bitmap = Bitmap.createBitmap(v1.drawingCache)
            v1.isDrawingCacheEnabled = false

            val imageFile = File(mPath)

            val outputStream = FileOutputStream(imageFile)
            val quality = 100
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
            outputStream.flush()
            outputStream.close()

            //setting screenshot in imageview
            val filePath = imageFile.getPath()

            Log.d("fffff",filePath)
            sharePath = filePath

        } catch (e: Throwable) {
            Log.d("fffff",e.message)
            // Several error may come out with file handling or DOM
            e.printStackTrace()
        }

    }

    private fun share(sharePath: String) {

        Log.d("ffff", sharePath)
        val file = File(sharePath)
        val uri = FileProvider.getUriForFile(this,
            "rose.cheny16.projectfragment", file)
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_STREAM, uri)
        startActivity(intent)

    }

    fun save(){


        val builder = AlertDialog.Builder(this)
        builder.setMessage("Save current game state? \nNew save slot will appear on top").setPositiveButton("Yes", dialogClickListener)
            .setNegativeButton("No", dialogClickListener).show()

    }

    val dialogClickListener = DialogInterface.OnClickListener { dialogInterface, i ->
        when (i){

            DialogInterface.BUTTON_POSITIVE -> {
                val user = auth.currentUser
                this.saveLoadFragment = fragment_saveload.newInstance(user!!.uid, "")
                saveLoadFragment!!.listener = this
                var saveloadFT = supportFragmentManager.beginTransaction()
                saveloadFT.replace(R.id.fragment_container,saveLoadFragment,"login")
                saveloadFT.addToBackStack("list")
                saveloadFT.commit()
                Toast.makeText(this,
                    "game saved",
                    Toast.LENGTH_LONG
                ).show()
            }

            DialogInterface.BUTTON_NEGATIVE -> {
                val user = auth.currentUser
                this.saveLoadFragment = fragment_saveload.newInstance(user!!.uid, "l")
                saveLoadFragment!!.listener = this
                var saveloadFT = supportFragmentManager.beginTransaction()
                saveloadFT.replace(R.id.fragment_container,saveLoadFragment,"login")
                saveloadFT.addToBackStack("list")
                saveloadFT.commit()
            }

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {

            R.id.action_settings -> {
                var builder = AlertDialog.Builder(this)
                var view = LayoutInflater.from(this).inflate(R.layout.menudialog,null,false)
                initControls(view.seekBar)
                builder.setView(view)
                builder.setTitle("Settings")
                builder.setPositiveButton(android.R.string.ok,{_,_ ->
                    val name = view.edit_name.text.toString()
                    player.name = name

                })
                builder.setNegativeButton(android.R.string.cancel,null)
                builder.show()
                true
            }

            R.id.action_save -> {
                save()
                true
            }

            R.id.action_logout ->{
                if(auth.uid == null){
                    Toast.makeText(this,"You have Logged Out!" ,Toast.LENGTH_LONG).show()
                }else{
                    var builder = AlertDialog.Builder(this)
                    val view = LayoutInflater.from(this).inflate(R.layout.dialog_view,null,false)
                    builder.setView(view)
                    builder.setTitle("Confirm Logout")
                    builder.setNegativeButton(android.R.string.cancel,null)
                    builder.setPositiveButton(android.R.string.ok,{_,_ ->
                        auth.signOut()
                        Toast.makeText(this,"You have Logged Out!" ,Toast.LENGTH_SHORT).show()
                    })
                    builder.show()

                }


                true
            }
            R.id.action_help ->{
                if(auth.uid != null){
                    var ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.fragment_container,fragment_story.newInstance("BobEvent1"),"login")
                    ft.addToBackStack("list")
                    ft.commit()

                }else{
                    Toast.makeText(this,"You have to Login!",Toast.LENGTH_SHORT).show()
                }

                true
            }
            R.id.action_share ->{
                takeScreenshot()
                share(sharePath)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
