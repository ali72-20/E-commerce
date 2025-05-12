package com.example.domain.use_cases.auth_use_cases

import UserEntity
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.SignupRequestEntity
import com.example.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignupUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend fun invoke(signupRequestEntity: SignupRequestEntity) : Flow<ApiResult<UserEntity>>{
        return authRepository.signup(signupRequestEntity)
    }
}