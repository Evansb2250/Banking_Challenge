package com.veryable.android.repository

import android.util.JsonToken
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.veryable.android.domain.AccountDomain
import com.veryable.android.dto.AccountDTO
import com.veryable.android.dto.dtoModelAsDomain
import com.veryable.android.network.WebserviceAPI
import com.veryable.android.network.getAccountDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class Repository {
    //wrap accountDetails with _acccountDetails
    private val _accountDetails = MutableLiveData<List<AccountDomain>>()
    val accountDetails:LiveData<List<AccountDomain>> get()= _accountDetails


    fun requestNetworkFetch(){
        CoroutineScope(Dispatchers.Default).launch {
            getAccountDetails()?.let {
                val classes = Json.decodeFromString<ArrayList<AccountDTO>>(it)
                //extension function to transform the DTO model into a Domain model
                //post value lets me initialize _accountDetails asynchronously
                _accountDetails.postValue(classes.dtoModelAsDomain())
            }
        }
    }
}