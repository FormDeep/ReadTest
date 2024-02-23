package com.toporead.readtest


import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE =153


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_menu)

        navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_read ->{switchFragment(ReadFragment())
                true
                }
                R.id.navigation_web ->{switchFragment(WebFragment())
                    true
                }
                R.id.navigation_setting ->{switchFragment(SettingFragment())
                    true
                }

                else -> false
            }
        }






       if (ContextCompat.checkSelfPermission(this@MainActivity,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
           ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)
       }


    }

    fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.nav_fragment,fragment).commit()
    }


}