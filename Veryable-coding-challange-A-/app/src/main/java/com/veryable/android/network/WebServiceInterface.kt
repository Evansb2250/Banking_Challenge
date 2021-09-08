package com.veryable.android.network

import retrofit2.http.GET

interface WebServiceInterface {
    //endPoint
    @GET("/veryable.json")
    suspend fun getAccountDetails(): String?
}