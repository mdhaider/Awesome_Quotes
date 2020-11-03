package com.nehal.awesomequotes.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Url.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(myHttpClient())
            .build()
    }
    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }

    private fun myHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .addInterceptor(ErrorInterceptor()).addInterceptor(AuthTokenInterceptor())
        return builder.build()
    }


}

