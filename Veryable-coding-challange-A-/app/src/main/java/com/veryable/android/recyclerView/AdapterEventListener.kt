package com.veryable.android.recyclerView

import com.veryable.android.domain.AccountDomain

//Custom click listener for the AccountViewHolder
class AdapterEventListener(val clickListener: (account: AccountDomain) -> Unit ){
    fun onClick(accountId: AccountDomain) = accountId.id.let { clickListener(accountId) }
}