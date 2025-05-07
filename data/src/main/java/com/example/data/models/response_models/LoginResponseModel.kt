package com.example.data.models.response_models

import UserEntity
import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("user")
    val user: User? = null,
    @SerializedName("token")
    val token: String? = null
) {
    fun toDomain(): UserEntity {
        return UserEntity(
            role = user?.role,
            name = user?.name,
            email = user?.email
        )
    }
}


data class User(
    @SerializedName("role")
    val role: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("email")
    val email: String? = null
)
