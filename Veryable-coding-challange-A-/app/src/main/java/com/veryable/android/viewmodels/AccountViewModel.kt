package com.veryable.android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.veryable.android.domain.AccountDomain
import com.veryable.android.repository.Repository

class AccountViewModel : ViewModel() {
    val repository = Repository()
    val accountDetails:LiveData<List<AccountDomain>> = repository.accountDetails



    init{
        repository.requestNetworkFetch()
    }
}