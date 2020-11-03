package com.nehal.awesomequotes.model

import com.google.gson.annotations.SerializedName

data class Quotes(
	@SerializedName("objectId")
	val objectId: String,
	@SerializedName("quoteText")
	val quoteText: String,
	@SerializedName("quoteAuthor")
	val quoteAuthor: String,
	@SerializedName("Category")
	val category: String,
	@SerializedName("createdAt")
	val createdAt: String,
	@SerializedName("updatedAt")
	val updatedAt: String
)