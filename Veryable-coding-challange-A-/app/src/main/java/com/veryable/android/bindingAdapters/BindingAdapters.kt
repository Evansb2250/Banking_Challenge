package com.veryable.android.bindingAdapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.veryable.android.R
import com.veryable.android.constants.BANK_STRING
import com.veryable.android.constants.BANK_TRANSFER_SPEED
import com.veryable.android.constants.CARD_TRANSFER_SPEED
import com.veryable.android.domain.AccountDomain


@BindingAdapter("accountImageType")
fun bindAccountImage(imageView: ImageView, accountDomain: AccountDomain){
    imageView.setImageResource(
        when(accountDomain.accountType.accountType){
            BANK_STRING -> R.drawable.ic__578836_and_bank_building_business_capital_icon
            else -> R.drawable.ic__763513_atm_card_bank_card_cash_card_credit_card_plastic_money_icon
        }
    )
}



@BindingAdapter("accountTransferSpeed")
fun bindAccountTransferDetail(textView: TextView, accountDomain: AccountDomain){
    textView.text = if(accountDomain.accountType.accountType.equals(BANK_STRING)) BANK_TRANSFER_SPEED else CARD_TRANSFER_SPEED
}