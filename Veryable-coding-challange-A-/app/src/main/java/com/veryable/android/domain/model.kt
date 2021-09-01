package com.veryable.android.domain

import com.veryable.android.constants.BANK_STRING
import com.veryable.android.constants.CARD_STRING



data class AccountDomain (
     var id: Int,
     var accountType: AccountType,
     var accountName: String,
     var desc:String
)


enum class AccountType(val accountType:String){
    CARD(CARD_STRING), BANK(BANK_STRING)
}