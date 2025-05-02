package com.example.e_commerce.core.navigation

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppNavigatorModule {
    @Provides
    fun provideAppNavigator(): AppNavigator {
        return AppNavigator()
    }
}