package com.example.e_commerce.managers.login

import com.example.e_commerce.managers.login.LoginScreenFormStates
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object LoginDependencyModule {
    @Provides
    fun provideValidatorManager(): ValidatorManager{
        return ValidatorManager()
    }

    @Provides
    fun provideLoginScreenFormState(): LoginScreenFormStates{
        return LoginScreenFormStates
    }
}