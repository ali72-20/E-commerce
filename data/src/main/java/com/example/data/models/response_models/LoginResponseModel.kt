package com.example.data.models.response_models

data class LoginResponseModel(
	val message: String? = null,
	val user: User? = null,
	val token: String? = null
)


data class User(
	val role: String? = null,
	val name: String? = null,
	val email: String? = null
)
