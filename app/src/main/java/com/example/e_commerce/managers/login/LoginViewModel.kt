package com.example.e_commerce.managers.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validatorManager: ValidatorManager,
) : ViewModel() {

    private fun goToRegisterScreen() {
        viewModelScope.launch {

        }
    }

    private fun login() {

    }

    fun doAction(action: LoginScreenActions) {
        when (action) {
            is GoToRegisterAction -> goToRegisterScreen()
            is LoginAction -> TODO()
        }
    }
}