package com.nehal.awesomequotes.model

import com.google.gson.annotations.SerializedName

data class QuoteResponse (
	@SerializedName("results")
	val results : List<Quotes>
)