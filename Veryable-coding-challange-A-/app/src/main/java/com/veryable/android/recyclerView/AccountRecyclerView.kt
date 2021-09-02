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
        private val accountImageView = binding.accountTypeImageView
        private val accountNameTextView = binding.accountNameTextView
        private val accountDescTextView = binding.accountDescTextView
        private val accountTransferTypeTextView = binding.accountTransferTypeTextView

        init {
            accountViewArrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24)
        }

        fun bind(accountItem: AccountDomain) {
            accountNameTextView.text = accountItem.accountName
            accountDescTextView.text = accountItem.desc
            accountTransferTypeTextView.text = accountItem.accountType.toString()

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountAdapter.AccountItemViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: AccountAdapter.AccountItemViewHolder, position: Int) {
        val accountItem = getItem(position)
        holder.bind(accountItem)
    }


    companion object{
        fun from(parent: ViewGroup):AccountItemViewHolder{
            val layoutInflator = LayoutInflater.from(parent.context)
            val binding = AccountItemsBinding.inflate(layoutInflator,parent, false)
            return AccountItemViewHolder(binding)
        }
    }

}



//must take an account so that
class AccountDiffUtil: DiffUtil.ItemCallback<AccountDomain>() {
    override fun areItemsTheSame(oldItem: AccountDomain, newItem: AccountDomain): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AccountDomain, newItem: AccountDomain): Boolean {
        return oldItem == newItem
    }

}



class AdapterEventListener(val clickListener: (account:AccountDomain) -> Unit ){
    fun onClick(accountId: AccountDomain) = accountId.id?.let { clickListener(accountId) }
}