package com.veryable.android.dto


import com.veryable.android.constants.CARD_STRING
import com.veryable.android.domain.AccountDomain
import com.veryable.android.domain.AccountType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable





@Serializable
data class AccountDTO(
    @SerialName("id") var id: Int,
    @SerialName("account_type")var accountType:String,
    @SerialName("account_name")var accountName: String,
    @SerialName("desc")var desc:String
)


fun ArrayList<AccountDTO>.dtoModelAsDomain(): List<AccountDomain> {
    return map {
        AccountDomain (
            id = it.id,
            accountType = if(it.accountType.equals(CARD_STRING)) AccountType.CARD else AccountType.BANK,
            accountName = it.accountName,
            desc = it.desc
        )
    }


}


