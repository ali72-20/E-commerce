package com.example.data.repository

import UserEntity
import com.example.data.core.signupRequestModelDto
import com.example.data.core.signupResponseModelDto
import com.example.data.data_sources.AuthRemoteDataSource
import com.example.data.models.request_models.LoginRequestModel
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.LoginRequestEntity
import com.example.domain.entities.request_entities.SignupRequestEntity
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import safeApiCall
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource) :
    AuthRepository {
    override suspend fun login(loginRequestEntity: LoginRequestEntity): Flow<ApiResult<UserEntity>> {
        return safeApiCall<UserEntity>({
            val response = authRemoteDataSource.login(LoginRequestModel.fromDomain(loginRequestEntity))
            response.toDomain()
        })
    }

    override suspend fun signup(signupRequestEntity: SignupRequestEntity): Flow<ApiResult<UserEntity>> {
         return safeApiCall<UserEntity>({
             val response = authRemoteDataSource.signup(signupRequestModelDto(signupRequestEntity))
             signupResponseModelDto(response)
         })
    }
}