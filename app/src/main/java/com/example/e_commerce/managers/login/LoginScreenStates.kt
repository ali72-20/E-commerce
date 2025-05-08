package com.example.e_commerce.managers.login

data class LoginScreenStates(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
    val navigateToRegister: Boolean = false,
)

