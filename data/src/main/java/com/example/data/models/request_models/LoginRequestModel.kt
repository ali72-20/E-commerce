package com.example.data.models.request_models

import com.example.domain.entities.request_entities.LoginRequestEntity
import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @SerializedName("email")
    var email:String,
    @SerializedName("password")
    var password: String
){
    fun fromDomain(loginRequestEntity: LoginRequestEntity){
        email = loginRequestEntity.email
        password = loginRequestEntity.password
    }
}
