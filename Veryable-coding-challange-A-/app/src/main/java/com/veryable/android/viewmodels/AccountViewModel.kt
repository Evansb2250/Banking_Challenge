package com.veryable.android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veryable.android.domain.AccountDomain
import com.veryable.android.repository.Repository

class AccountViewModel : ViewModel() {
    private val repository = Repository()
    val accountDetails:LiveData<List<AccountDomain>> = repository.accountDetails

    private val _selectedAccount = MutableLiveData<AccountDomain>()
    val selectedAccount: LiveData<AccountDomain>get() = _selectedAccount


    fun navigateToAccount(account: AccountDomain){
        _selectedAccount.value = account
    }
    fun navigationCompleted(){
        _selectedAccount.value = null
    }



    init{
        repository.requestNetworkFetch()
        _selectedAccount.value = null
    }
}