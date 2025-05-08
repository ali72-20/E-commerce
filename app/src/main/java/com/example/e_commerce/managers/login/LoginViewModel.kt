package com.example.e_commerce.managers.login

import UserEntity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.LoginRequestEntity
import com.example.domain.use_cases.auth_use_cases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validatorManager: ValidatorManager,
    val loginScreenFormStates: LoginScreenFormStates,
    private val loginUseCase: LoginUseCase
) : ViewModel() {


    fun isValidEmail(): String? {
        if (!validatorManager.validateEmail(loginScreenFormStates.email.value)) {
            return "Email is not valid"
        }
        return null
    }

    fun isValidPassword(): String? {
        if (!validatorManager.validatePassword(loginScreenFormStates.password.value)) {
            return "Not valid password"
        }
        return null
    }

    private val _uiState = MutableStateFlow(LoginScreenStates())
    val uiState: StateFlow<LoginScreenStates> = _uiState.asStateFlow()

    private suspend fun login() {
        if (isValidEmail() != null) {
            return
        }
        if (isValidPassword() != null) {
            return
        }
        _uiState.value = _uiState.value.copy(
            isLoading = true
        )
        val result = loginUseCase.invoke(LoginRequestEntity(loginScreenFormStates.email.value, LoginScreenFormStates.password.value))
        when (result) {
            is ApiResult.Success<UserEntity> -> {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess = true
                )
            }

            is ApiResult.Failure<*> -> {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isFailure = true
                )
            }
        }
    }

    private fun changePasswordVisibility() {
        loginScreenFormStates.isVisiblePassword.value = !loginScreenFormStates.isVisiblePassword.value
    }

    fun onAction(actions: LoginScreenActions) {
        when (actions) {
            LoginScreenActions.LoginAction -> {
                viewModelScope.launch {
                    login()
                }
            }

            LoginScreenActions.ChangePasswordVisibilityAction ->
                changePasswordVisibility()
        }
    }
}

