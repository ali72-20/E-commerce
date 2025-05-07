package com.example.data.api

import com.example.data.models.request_models.LoginRequestModel
import com.example.data.models.response_models.LoginResponseModel
import retrofit2.http.Body
import retrofit2.http.POST


interface WebServices {
    @POST(ApiEndPoints.LOGIN)
    suspend fun login(@Body loginRequest: LoginRequestModel): LoginResponseModel
}