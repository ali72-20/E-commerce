package com.example.e_commerce.managers.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.core.navigation.AppNavigator
import com.example.e_commerce.core.navigation.AppRoutes
import com.example.e_commerce.core.navigation.NavigationCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validatorManager: ValidatorManager,
    private val appNavigator: AppNavigator
) : ViewModel() {

    private fun goToRegisterScreen() {
        viewModelScope.launch {
            appNavigator.navigate(NavigationCommand.NavigateTo(AppRoutes.Register.route))
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