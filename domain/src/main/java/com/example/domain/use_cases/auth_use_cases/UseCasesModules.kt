package com.example.domain.use_cases.auth_use_cases

import com.example.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModules {
    @Provides
    fun provideLoginUseCase(authRepository: AuthRepository): LoginUseCase{
        return LoginUseCase(authRepository)
    }


    @Provides
    fun provideSignupUseCase(authRepository: AuthRepository): SignupUseCase{
        return SignupUseCase(authRepository)
    }
}