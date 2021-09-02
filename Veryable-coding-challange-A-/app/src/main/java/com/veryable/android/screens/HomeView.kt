package com.veryable.android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account,container, false)

        setTitleToHome()


        val adapter = AccountAdapter(AdapterEventListener { account ->
            //passes the account instance to display in the details fragment
            accountViewModel.navigateToAccount(account)
            //triggers only one event to navigate to details fragment
            accountViewModel.navigationCompleted()
        })

        //binds the viewModel with the accountViewModel.
        binding.accountViewModel = accountViewModel


        binding.recyclerView.adapter = adapter

        accountViewModel.accountDetails.observe(viewLifecycleOwner, { it ->
           //passes the list of accounts to the listAdapter
            adapter.submitList(it)
        })


        accountViewModel.selectedAccount.observe(viewLifecycleOwner, { account ->
            account?.let {
               findNavController().navigate(HomeViewDirections.actionAccountToDetailView(account))
            }

        })

        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setTitleToHome() {
        val toolBarText = requireActivity().findViewById<TextView>(R.id.titleTextView)
        toolBarText.setText(R.string.homeTitle)
    }

}