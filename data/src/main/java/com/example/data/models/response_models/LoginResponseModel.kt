package com.example.data.models.response_models

import UserEntity
import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @field: SerializedName("message")
    val message: String? = null,
    @field:SerializedName("user")
    val user: LoginUser? = null,
    @field:SerializedName("token")
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


data class LoginUser(
    @field:SerializedName("role")
    val role: String? = null,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("email")
    val email: String? = null
)
