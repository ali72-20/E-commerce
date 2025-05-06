package com.example.e_commerce.managers.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(RegisterScreenStates())
    fun onAction(action: RegisterActions) {
        when (action) {
            RegisterActions.NavigateToLoginAction -> state = state.copy(navigateToLoginState = true)
        }
    }
}
