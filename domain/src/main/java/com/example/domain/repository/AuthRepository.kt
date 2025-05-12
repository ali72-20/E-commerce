package com.example.domain.repository

import UserEntity
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.LoginRequestEntity
import com.example.domain.entities.request_entities.SignupRequestEntity
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(loginRequestEntity: LoginRequestEntity): Flow<ApiResult<UserEntity>>
    suspend fun  signup(signupRequestEntity: SignupRequestEntity):Flow<ApiResult<UserEntity>>
}