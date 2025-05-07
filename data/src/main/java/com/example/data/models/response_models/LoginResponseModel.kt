package com.example.data.models.response_models

data class LoginResponseModel(
	val message: String? = null,
	val user: User? = null,
	val token: String? = null
){
	fun toDomain():UserEntity{
		return UserEntity(
			name = user.name,
			email = user.email,
			role = user.role
		)
	}
}


data class User(
	val role: String? = null,
	val name: String? = null,
	val email: String? = null
)
