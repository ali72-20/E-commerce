package com.example.data.data_sources

import com.example.data.api.WebServices
import com.example.data.models.request_models.LoginRequestModel
import com.example.data.models.response_models.LoginResponseModel
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val webServices: WebServices) : AuthRemoteDataSource{
    override suspend fun login(loginRequestModel: LoginRequestModel): LoginResponseModel {
         return  webServices.login(loginRequestModel)
    }
}