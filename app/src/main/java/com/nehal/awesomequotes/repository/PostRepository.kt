package com.nehal.awesomequotes.repository


import com.nehal.awesomequotes.model.QuoteResponse
import com.nehal.awesomequotes.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository {

    fun getPost(map:MutableMap<String, String>): Flow<QuoteResponse> = flow {
        val postList = RetrofitBuilder.ROUTES.getPost(map)
        emit(postList)
    }.flowOn(Dispatchers.IO)
}