import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.e_commerce.core.navigation.AppNavigator
import com.example.e_commerce.core.navigation.AppRoutes
import com.example.e_commerce.core.navigation.NavigationCommand
import com.example.e_commerce.fragments.home.HomeFragment
import com.example.e_commerce.fragments.login.LoginFragment
import com.example.e_commerce.fragments.register.RegisterFragment

@Composable
fun AppNavigationManager(navigator: AppNavigator) {
    val navController = rememberNavController()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        navigator.commands.collect { command ->
            when (command) {
                is NavigationCommand.NavigateTo -> navController.navigate(command.route)
                NavigationCommand.NavigateBack -> navController.popBackStack()
            }
        }
    }

    NavHost(navController, startDestination = AppRoutes.Login.route) {
        composable(AppRoutes.Login.route) { LoginFragment() }
        composable(AppRoutes.Home.route) { HomeFragment() }
        composable(AppRoutes.Register.route) { RegisterFragment() }
    }
}
