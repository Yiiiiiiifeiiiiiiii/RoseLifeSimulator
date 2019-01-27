package rose.cheny16.projectfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), fragment_mainpage.IgetFt{

    override fun getFt(): FragmentTransaction {
        return supportFragmentManager.beginTransaction()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        var ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container,fragment_login(),"login")
        ft.commit()
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
                true
            }
            R.id.action_saveload -> {
                var saveloadFT = supportFragmentManager.beginTransaction()
                saveloadFT.replace(R.id.fragment_container,fragment_saveload(),"login")
                saveloadFT.addToBackStack("list")
                saveloadFT.commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
