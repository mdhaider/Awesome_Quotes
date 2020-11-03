package com.nehal.awesomequotes.network

import com.nehal.awesomequotes.model.QuoteResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface Routes {

    @GET("classes/Quotes")
    suspend fun getPost(@QueryMap options: Map<String, String>) : QuoteResponse
}