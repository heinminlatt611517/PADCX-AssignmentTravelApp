package com.heinminlatt.padcx_assignmenttravelapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.heinminlatt.padcx_assignmenttravelapp.R
import com.heinminlatt.padcx_assignmenttravelapp.fragements.DetailFragment
import com.heinminlatt.padcx_assignmenttravelapp.fragements.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        changeFragemnt(MainFragment.newInstance("Home","Home"))
        navigation_main.setOnNavigationItemSelectedListener (object :
            BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId) {
                    R.id.icon_home -> {
                        changeFragemnt(MainFragment.newInstance("Home","Home"))
                        return true
                    }
                    R.id.icon_favourite -> {
                        changeFragemnt(DetailFragment.newInstance("Detail","Detail"))

                        return true
                    }
                }

                return false
            }


        })

    }

    private fun changeFragemnt(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit()
    }
}
