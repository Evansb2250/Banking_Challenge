package com.veryable.android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.veryable.android.R
import com.veryable.android.databinding.FragmentAccountBinding
import com.veryable.android.recyclerView.AccountAdapter
import com.veryable.android.recyclerView.AdapterEventListener
import com.veryable.android.viewmodels.AccountViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class HomeView : Fragment() {
/*

 */
   private val accountViewModel = AccountViewModel()
   private lateinit var binding: FragmentAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account,container, false)



        val adapter = AccountAdapter(AdapterEventListener {
            //Set the account that was clicked

        })


        binding.accountViewModel = accountViewModel

        binding.recyclerView.adapter = adapter
        accountViewModel.accountDetails.observe(viewLifecycleOwner, { it ->
            adapter.submitList(it)
        })

        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        return binding.root
    }

}