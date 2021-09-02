package com.veryable.android.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.veryable.android.domain.AccountDomain

class AccountDiffUtil: DiffUtil.ItemCallback<AccountDomain>() {
    override fun areItemsTheSame(oldItem: AccountDomain, newItem: AccountDomain): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AccountDomain, newItem: AccountDomain): Boolean {
        return oldItem == newItem
    }

}

