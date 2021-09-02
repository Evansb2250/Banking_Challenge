package com.veryable.android

import android.annotation.SuppressLint
import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.veryable.android.databinding.ActivityPayoutsListBinding

class PayoutsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPayoutsListBinding
    private lateinit var navHostFrag: NavHostFragment
    private lateinit var navController: NavController

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_list)


        //Create as NavHostFragment so navcontroller instance can be created
        navHostFrag = supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment

        val navController = navHostFrag.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

        //Created a custom view so I can position the title and change it
        this.getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        this.getSupportActionBar()?.setCustomView(R.layout.toolbar_layout)


    }

    override fun onSupportNavigateUp(): Boolean {
        navController = navHostFrag.navController
        return navController.navigateUp()
    }


}