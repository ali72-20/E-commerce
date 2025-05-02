package com.example.e_commerce.core.navigation

sealed class NavigationCommand {
    data class NavigateTo(val route: String) : NavigationCommand()
    object NavigateBack : NavigationCommand()
}
