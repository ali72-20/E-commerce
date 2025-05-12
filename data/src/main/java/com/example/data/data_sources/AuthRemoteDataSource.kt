package com.example.data.data_sources

import com.example.data.models.request_models.LoginRequestModel
import com.example.data.models.request_models.SignupRequestModel
import com.example.data.models.response_models.LoginResponseModel
import com.example.data.models.response_models.SignupResponseModel

interface AuthRemoteDataSource {
    suspend fun login(loginRequestModel: LoginRequestModel): LoginResponseModel

    suspend fun signup(signupRequestModel: SignupRequestModel): SignupResponseModel
}