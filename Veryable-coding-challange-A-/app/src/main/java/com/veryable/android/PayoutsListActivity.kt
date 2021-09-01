package com.veryable.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.veryable.android.databinding.ActivityPayoutsListBinding
import com.veryable.android.network.WebserviceAPI
import com.veryable.android.repository.Repository
import com.veryable.android.viewmodels.AccountViewModel

class PayoutsListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPayoutsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_list)
        val viewModelTest = AccountViewModel()

        viewModelTest.accountDetails.observe(this, { it ->
            Toast.makeText(this, "GOT INFO", Toast.LENGTH_LONG).show()
        })
    }
}