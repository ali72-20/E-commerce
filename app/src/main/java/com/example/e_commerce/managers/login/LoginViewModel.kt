package com.example.e_commerce.managers.login

import UserEntity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.core.ApiResult
import com.example.domain.entities.request_entities.LoginRequestEntity
import com.example.domain.use_cases.auth_use_cases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validatorManager: ValidatorManager,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    var email: String = ""
    var password: String = ""

    private fun isValidEmail(): String?{
        if(!validatorManager.validateEmail(email)){
            return "Email is not valid"
        }
        return null
    }

    private fun isValidPassword(): String?{
        if(!validatorManager.validatePassword(password)){
            return "Not valid password"
        }
        return null
    }

    private val _uiState = MutableStateFlow(LoginScreenStates())
    val uiState: StateFlow<LoginScreenStates> = _uiState.asStateFlow()

    private suspend fun login(){
        if(isValidEmail()!=null){return}
        if(isValidPassword() != null){return}
        _uiState.value = _uiState.value.copy(
            isLoading = true
        )
        val result = loginUseCase.invoke(LoginRequestEntity(email, password))
        when(result){
            is ApiResult.Success<UserEntity>->{
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isSuccess =  true
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

    fun onAction(actions: LoginScreenActions): String {
        return when (actions) {
            LoginScreenActions.LoginAction -> TODO()
        }
    }


}