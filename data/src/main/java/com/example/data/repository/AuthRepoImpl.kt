package com.example.data.repository

import UserEntity
import com.example.data.data_sources.AuthRemoteDataSource
import com.example.data.models.request_models.LoginRequestModel
import com.example.domain.entities.request_entities.LoginRequestEntity
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource) :
    AuthRepository {
    override suspend fun login(loginRequestEntity: LoginRequestEntity): UserEntity {
        val response = authRemoteDataSource.login(LoginRequestModel.fromDomain(loginRequestEntity))
        return response.toDomain()
    }
}