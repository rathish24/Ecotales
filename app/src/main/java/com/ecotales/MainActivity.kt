package com.ecotales

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import com.ecotales.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private var fab_open: Animation? = null
    private var fab_close:Animation? = null
    private  var fab_clock:Animation? = null
    private  var fab_anticlock:Animation? = null


    var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        navController= Navigation.findNavController(this,R.id.nav_host_fragment_content_main)
        setupWithNavController(binding.bottomNavigationView,navController)

//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            if (isOpen) {
                binding.textviewMail.visibility = View.INVISIBLE
                binding.textviewShare.visibility = View.INVISIBLE
                binding.fab2.startAnimation(fab_close)
                binding.fab1.startAnimation(fab_close)
                binding.fab.startAnimation(fab_anticlock)
                binding.fab2.isClickable = false
                binding.fab1.isClickable = false
                isOpen = false;
            } else {

                binding.textviewMail.visibility = View.VISIBLE
                binding.textviewShare.visibility = View.VISIBLE
                binding.fab2.startAnimation(fab_open)
                binding.fab1.startAnimation(fab_open)
                binding.fab.startAnimation(fab_clock)
                binding.fab2.isClickable = true;
                binding.fab1.isClickable = true;
                isOpen = true;
            }


            binding.fab2.setOnClickListener(View.OnClickListener {

                val intent = Intent(this, AddWetLog::class.java)
                startActivity(intent)

            })

            binding.fab1.setOnClickListener(View.OnClickListener {


                Toast.makeText(
                    applicationContext,
                    "Coming Soon",
                    Toast.LENGTH_SHORT
                ).show()
            })
            //   val appDatabase = AppDatabase.getInstance(applicationContext)

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
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}