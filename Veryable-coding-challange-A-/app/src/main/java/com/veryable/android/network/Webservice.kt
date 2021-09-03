package com.veryable.android.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.veryable.android.dto.AccountDTO
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.io.IOException

/*
1. create retrofit object
2. create retrofit interface function
3. define the interface function
4. create an object of the Webservice

 */

//Webservice address
private  const val endPoint = "https://veryable-public-assets.s3.us-east-2.amazonaws.com"



// create the retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(endPoint)
    .build()


//create the interface
 interface webServiceInterface{
    //endPoint
    @GET("/veryable.json")
    suspend fun getAccountDetails(): String?
}





object WebserviceAPI {
    //creates one retrofit service variable associated with
    // WebServiceAPI
    val retrofitService:webServiceInterface by lazy {
        retrofit.create(webServiceInterface::class.java)
    }
}


suspend fun getAccountDetails(): String? {
    try{
        return WebserviceAPI.retrofitService.getAccountDetails()
    }catch (e:Exception){

    }

    return null
}


