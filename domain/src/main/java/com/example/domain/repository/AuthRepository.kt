package com.example.domain.repository

import UserEntity
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.LoginRequestEntity

interface AuthRepository {
    suspend fun login(loginRequestEntity: LoginRequestEntity): ApiResult<UserEntity>
}