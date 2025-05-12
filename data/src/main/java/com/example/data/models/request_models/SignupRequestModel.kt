package com.example.data.models.request_models

import com.google.gson.annotations.SerializedName

data class SignupRequestModel(
	@field:SerializedName("password")
	val password: String,
	@field:SerializedName("phone")
	val phone: String,
	@field:SerializedName("rePassword")
	val rePassword: String,
	@field:SerializedName("name")
	val name: String,
	@field:SerializedName("email")
	val email: String,
)