package com.example.data.data_sources

import com.example.data.models.request_models.LoginRequestModel
import com.example.data.models.response_models.LoginResponseModel

interface AuthRemoteDataSource {
    suspend fun login(loginRequestModel: LoginRequestModel): LoginResponseModel
}