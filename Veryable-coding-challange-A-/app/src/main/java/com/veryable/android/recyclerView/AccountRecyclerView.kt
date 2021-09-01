package com.veryable.android.recyclerView

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.veryable.android.domain.AccountDomain


class AccountAdapter(val clickListener: AdapterEventListener) :
    ListAdapter<AccountDomain, AccountAdapter.AccountItemViewHolder>(AccountDiffUtil()) {

    class AccountItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }





    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AccountAdapter.AccountItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AccountAdapter.AccountItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}



//must take an account so that
class AccountDiffUtil: DiffUtil.ItemCallback<AccountDomain>() {
    override fun areItemsTheSame(oldItem: AccountDomain, newItem: AccountDomain): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: AccountDomain, newItem: AccountDomain): Boolean {
        TODO("Not yet implemented")
    }

}


class AdapterEventListener(val clickListener: (account:AccountDomain) -> Unit ){
    fun onClick(accountId: AccountDomain) = accountId.id?.let { clickListener(accountId) }
}