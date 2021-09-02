package com.veryable.android.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.veryable.android.R
import com.veryable.android.constants.BANK_STRING
import com.veryable.android.domain.AccountDomain


@BindingAdapter("accountImageType")
fun bindAccountImage(imageView: ImageView, accountDomain: AccountDomain){
    imageView.setImageResource(
        when(accountDomain.accountType.accountType){
            BANK_STRING -> R.drawable.baseline_account_balance_black_48pt_1x
            else -> R.drawable.baseline_credit_card_black_48pt_1x
        }
    )
}