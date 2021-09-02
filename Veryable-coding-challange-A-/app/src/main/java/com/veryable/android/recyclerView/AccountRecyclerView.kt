package com.veryable.android.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.veryable.android.R
import com.veryable.android.domain.AccountDomain
import java.util.zip.Inflater


class AccountAdapter(val clickListener: AdapterEventListener) :
    ListAdapter<AccountDomain, AccountAdapter.AccountItemViewHolder>(AccountDiffUtil()) {

    class AccountItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val accountImageView = itemView.findViewById<ImageView>(R.id.accountTypeImageView)
        private val accountNameTextView = itemView.findViewById<TextView>(R.id.accountNameTextView)
        private val accountDescTextView = itemView.findViewById<TextView>(R.id.accountDescTextView)
        private val accountTransferTypeTextView = itemView.findViewById<TextView>(R.id.accountDescTextView)



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


    companion object{
//        fun from(parent: ViewGroup):AccountItemViewHolder{
//            val layoutInflator = LayoutInflater.from(parent.context)
//        //    val binding = DataBindingUtil.inflate(layoutInflator, R.layout.activity_payouts_list,false)
//
//        }
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