package com.veryable.android.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
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
        setTitleToDetail()

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setTitleToDetail() {
        val toolBarText = requireActivity().findViewById<TextView>(R.id.titleTextView)
        toolBarText.setText(R.string.detailsTitle)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }
}

