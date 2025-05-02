package com.example.e_commerce.managers.login

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object ValidatorManagerModule {
    @Provides
    fun provideValidatorManager(): ValidatorManager{
        return ValidatorManager()
    }
}