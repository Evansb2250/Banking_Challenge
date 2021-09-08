package com.veryable.android.network

import retrofit2.Retrofit

object WebServiceAPI {
    //creates one retrofit service variable associated with
    // WebServiceAPI
    lateinit  var INSTANCE: WebServiceInterface

    val retrofitService:WebServiceInterface by lazy {
                getWebService()
    }


    fun getWebService():WebServiceInterface{
        if(::INSTANCE.isInitialized){
         return   INSTANCE
        }else{
            INSTANCE = retrofitFactory()
        }
          return  INSTANCE
    }
}