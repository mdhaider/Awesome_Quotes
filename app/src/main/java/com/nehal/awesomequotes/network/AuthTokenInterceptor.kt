package com.nehal.awesomequotes.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("X-Parse-Application-Id", "JcABJkhzoG2kLuTiA0Ief4EvoZLreP0TbYFruLmx")
            .header("X-Parse-REST-API-Key", "RNy26FjfY4IilAr84MhfdsRMuTwAdA5Lh4OqYNDs")
            .header("content-type", "application/json")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}