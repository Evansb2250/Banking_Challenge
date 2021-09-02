package com.veryable.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.veryable.android.databinding.ActivityPayoutsListBinding

class PayoutsListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPayoutsListBinding
    private lateinit var navHostFrag:NavHostFragment
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_list)
        //Navigation Controller
         navHostFrag =  supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment

        val navController = navHostFrag.navController
        this.setSupportActionBar(findViewById(R.id.toolbar))
        NavigationUI.setupActionBarWithNavController(this, navController)
        this.getSupportActionBar()?.setDisplayShowTitleEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        navController = navHostFrag.navController
        return navController.navigateUp()
    }


}