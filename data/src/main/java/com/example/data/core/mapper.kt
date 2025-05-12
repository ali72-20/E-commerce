package com.example.data.core

import UserEntity
import com.example.data.models.request_models.SignupRequestModel
import com.example.data.models.response_models.SignupResponseModel
import com.example.domain.entities.request_entities.SignupRequestEntity

fun signupRequestModelDto(signupRequestEntity: SignupRequestEntity): SignupRequestModel {
    return SignupRequestModel(
        name = signupRequestEntity.name,
        email = signupRequestEntity.email,
        password = signupRequestEntity.password,
        rePassword = signupRequestEntity.rePassword,
        phone = signupRequestEntity.phone
    )
}

fun signupResponseModelDto(signupResponseModel: SignupResponseModel):UserEntity{
    return UserEntity(
        role = signupResponseModel.user?.role,
        name = signupResponseModel.user?.name,
        email = signupResponseModel.user?.email
    )
}