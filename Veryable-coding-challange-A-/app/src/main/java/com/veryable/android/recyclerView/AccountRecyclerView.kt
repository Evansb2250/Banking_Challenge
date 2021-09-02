package com.veryable.android.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.veryable.android.R
import com.veryable.android.databinding.AccountItemsBinding
import com.veryable.android.domain.AccountDomain


class AccountAdapter(val clickListener: AdapterEventListener) :
    ListAdapter<AccountDomain, AccountAdapter.AccountItemViewHolder>(AccountDiffUtil()) {

    class AccountItemViewHolder(binding: AccountItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        private val accountViewArrow = binding.arrowImageView


        init {
            accountViewArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24)
        }

        fun bind(clickListener: AdapterEventListener, accountItem: AccountDomain) {


        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountAdapter.AccountItemViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: AccountAdapter.AccountItemViewHolder, position: Int) {
        val accountItem = getItem(position)
        holder.bind(clickListener,accountItem)
    }


    companion object{
        fun from(parent: ViewGroup):AccountItemViewHolder{
            val layoutInflator = LayoutInflater.from(parent.context)
            val binding = AccountItemsBinding.inflate(layoutInflator,parent, false)
            return AccountItemViewHolder(binding)
        }
    }

}



