package com.example.data.repository

import androidx.lifecycle.ViewModelLazy
import com.example.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AuthRepoModule {
    @Binds
    abstract fun bindAuthRepo(
        authRepoImpl: AuthRepoImpl

    ): AuthRepository
}