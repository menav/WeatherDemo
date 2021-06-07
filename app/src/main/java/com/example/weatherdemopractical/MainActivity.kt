package com.example.weatherdemopractical

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import com.example.weatherdemopractical.map.ui.MapsFragment
import com.example.weatherdemopractical.map.ui.help.HelpAndFaqFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.app_bar_main.view.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        appBarLayout?.toolbar?.menuIv?.setOnClickListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }

        nav_view.setNavigationItemSelectedListener(this)
        nav_view.menu.getItem(0).isChecked = true
        nav_view.menu.performIdentifierAction(R.id.nav_explore, 0)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_explore -> {
                appBarLayout.toolbar?.actionTitleTv?.text =
                    resources.getString(R.string.menu_explore)
                val fragment = MapsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit()
            }

            R.id.nav_help -> {
                appBarLayout.toolbar?.actionTitleTv?.text = resources.getString(R.string.menu_help)
                val fragment = HelpAndFaqFragment()
                supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).commit()
            }
        }
        item.isChecked = true
        drawer_layout.closeDrawers()
        return true
    }
}
