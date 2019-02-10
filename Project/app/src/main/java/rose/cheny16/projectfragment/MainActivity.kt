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






//class MainActivity : AppCompatActivity(), fragment_mainpage.IgetFt{
class MainActivity : AppCompatActivity(), fragment_mainpage.IgetFt, fragment_login.IgetFt,
    fragment_login.onLoginButtonPressedListener,fragment_saveload.OnFragmentInteractionListener,Status.IgetStatus {




    override fun setStatus(s: Status) {
        this.player = s;
    }

    override fun getStatus(): Status {
        return player
    }




    override fun onFragmentInteraction(uri: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val RC_SIGN_IN = 1
    lateinit var authListener: FirebaseAuth.AuthStateListener
    val auth = FirebaseAuth.getInstance()
    var saveLoadFragment: fragment_saveload? = null
    var player = Status()
    private var audioManager: AudioManager? = null


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
        initControls()
        initializeListeners()



    }

    private fun initControls() {
        try {
            var volumeSeekbar = findViewById(R.id.seekBar) as SeekBar
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                var builder = AlertDialog.Builder(this)
                var view = LayoutInflater.from(this).inflate(R.layout.menudialog,null,false)
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
                val user = auth.currentUser
                this.saveLoadFragment = fragment_saveload.newInstance(user!!.uid, "")
                saveLoadFragment!!.listener = this
                var saveloadFT = supportFragmentManager.beginTransaction()
                saveloadFT.replace(R.id.fragment_container,saveLoadFragment,"login")
                saveloadFT.addToBackStack("list")
                saveloadFT.commit()
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
            else -> super.onOptionsItemSelected(item)
        }
    }
}
