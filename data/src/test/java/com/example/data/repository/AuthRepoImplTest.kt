package com.example.data.repository

import com.example.data.data_sources.AuthRemoteDataSource
import org.junit.Test

class AuthRepoImplTest {
    @Test
    fun whenCallLogin_shouldCallRemoteDataSourceLogin() {
        val authRemoteDataSource = mockk<AuthRemoteDataSource>()

    }

}