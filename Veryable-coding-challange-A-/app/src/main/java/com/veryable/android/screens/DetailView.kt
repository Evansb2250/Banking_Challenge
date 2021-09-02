package com.veryable.android.screens

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.veryable.android.DataBinderMapperImpl
import com.veryable.android.R
import com.veryable.android.databinding.FragmentDetailViewBinding
import com.veryable.android.domain.AccountDomain


class DetailView : Fragment() {

    private val args :DetailViewArgs  by navArgs()
    private lateinit var binding:FragmentDetailViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_view, container, false)

        //got the account instance passed from the HomeViewFragment
        binding.account = args.account

        //navigates back to HomePage
        binding.doneButton.setOnClickListener{ it ->
            findNavController().navigate(DetailViewDirections.actionDetailViewToAccount())
        }


        setTitleToDetail()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setTitleToDetail() {
        val appCompatActivity = getActivity() as AppCompatActivity
         appCompatActivity.supportActionBar?.setCustomView(R.layout.toolbar_layout_details)
    }





}

