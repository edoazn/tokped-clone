package com.example.tokped_clone.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
