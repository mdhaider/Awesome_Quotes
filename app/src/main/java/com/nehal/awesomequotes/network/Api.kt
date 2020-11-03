package com.nehal.awesomequotes.network

import com.nehal.awesomequotes.model.QuoteResponse
import com.nehal.awesomequotes.model.Quotes
import retrofit2.http.GET

interface Api {

    @GET("classes/Quotes")
    suspend fun getPost() : QuoteResponse
}