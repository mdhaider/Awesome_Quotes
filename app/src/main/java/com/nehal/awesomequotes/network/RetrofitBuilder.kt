package com.nehal.awesomequotes.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Url.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(myHttpClient())
            .build()
    }
    val ROUTES: Routes by lazy {
        retrofit.create(Routes::class.java)
    }

    private fun myHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(ErrorInterceptor())
            .addInterceptor(AuthTokenInterceptor())
            .addInterceptor(LoggingInterceptor().setLogging())
        return builder.build()
    }


}

