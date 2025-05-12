package com.example.e_commerce.managers.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class LoginScreenStates(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
    val navigateToRegister: Boolean = false,
)

object LoginScreenFormStates {
    var email: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf("")
    var emailTouched: MutableState<Boolean> = mutableStateOf(false)
    var passwordTouched: MutableState<Boolean> = mutableStateOf(false)
    var isVisiblePassword: MutableState<Boolean> = mutableStateOf(false)
}
