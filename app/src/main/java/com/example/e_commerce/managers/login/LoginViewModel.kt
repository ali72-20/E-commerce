package com.example.e_commerce.managers.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validatorManager: ValidatorManager,
) : ViewModel() {

    var state by mutableStateOf(LoginScreenStates())
    fun onAction(actions: LoginScreenActions) {
        when (actions) {
            LoginScreenActions.GoToRegisterAction -> state = state.copy(navigateToRegister = true)
            LoginScreenActions.LoginAction -> TODO()
        }
    }

}