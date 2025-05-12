package com.example.domain.use_cases.auth_use_cases

import UserEntity
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.LoginRequestEntity
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun invoke(loginRequestEntity: LoginRequestEntity): Flow<ApiResult<UserEntity>>{
        return authRepository.login(loginRequestEntity)
    }
}