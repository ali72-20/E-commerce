package com.example.domain.entities.request_entities

data class SignupRequestEntity(
    val name: String,
    val email: String,
    val password: String,
    val rePassword: String,
    val phone : String
)
