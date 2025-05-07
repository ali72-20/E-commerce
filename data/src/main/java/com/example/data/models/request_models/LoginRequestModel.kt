package com.example.data.models.request_models

import com.example.domain.entities.request_entities.LoginRequestEntity

data class LoginRequestModel(
    var email:String,
    var password: String
){
    fun fromDomain(loginRequestEntity: LoginRequestEntity){
        email = loginRequestEntity.email
        password = loginRequestEntity.password
    }
}
