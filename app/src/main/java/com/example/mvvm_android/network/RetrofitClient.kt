package com.example.mvvm_android.network

import com.example.mvvm_android.AppConstant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        fun getInstance(url:String):Retrofit{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build()
        }
        /*val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()*/

    }

}


/*
object RetrofitClient {

    private var instance: Api? = null

    fun getInstance(): Api? {
        if (instance == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            instance = retrofit
        }
        return instance
    }
}*/
