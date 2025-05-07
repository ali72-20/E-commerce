package com.example.data.repository

import com.example.data.data_sources.AuthRemoteDataSource
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val authRemoteDataSource: AuthRemoteDataSource) :
    AuthRepository {

}