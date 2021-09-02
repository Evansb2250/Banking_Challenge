package com.veryable.android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        binding.account = args.account

        // Inflate the layout for this fragment
        return binding.root
    }

 }

