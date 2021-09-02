package com.veryable.android.screens

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //creates a binding object from the R.layout.fragment_account
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        setTitleToHome()


        val adapter = AccountAdapter(AdapterEventListener { account ->
            //passes the account instance to display in the details fragment
            accountViewModel.navigateToAccount(account)
            //triggers only one event to navigate to details fragment
            accountViewModel.navigationCompleted()
        })

        //binds the viewModel with the accountViewModel.
        binding.accountViewModel = accountViewModel
        //set the lifecycle to the life of the Fragment
        binding.lifecycleOwner = this


        //passes the instance of the adapter class to the recyclerview adapter
        binding.recyclerView.adapter = adapter

        //Live data that uses the observer pattern to alert fragment when data change
        accountViewModel.accountDetails.observe(viewLifecycleOwner, { it ->
            //passes the list of accounts to the listAdapter
            adapter.submitList(it)
        })

        //used to control when to navigate to the Details Fragment
        accountViewModel.selectedAccount.observe(viewLifecycleOwner, { account ->
            //uses let to check if account is null before using findNavController()
                account?.let {
                    findNavController().navigate(HomeViewDirections.actionAccountToDetailView(account))
                }
        })


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setTitleToHome() {
        val appCompatActivity = getActivity() as AppCompatActivity
        appCompatActivity.supportActionBar?.setCustomView(R.layout.toolbar_layout)
    }

}