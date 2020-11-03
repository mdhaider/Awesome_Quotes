package com.nehal.awesomequotes.repository


import com.nehal.awesomequotes.model.QuoteResponse
import com.nehal.awesomequotes.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository {

    fun getPost(): Flow<QuoteResponse> = flow {
        val postList = RetrofitBuilder.api.getPost()
        emit(postList)
    }.flowOn(Dispatchers.IO)
}