package com.example.e_commerce.fragments.login

import android.widget.Toast
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.e_commerce.R
import com.example.e_commerce.core.AppPadding
import com.example.e_commerce.core.shard_compose.CustomButton
import com.example.e_commerce.core.shard_compose.FormTextField
import com.example.e_commerce.managers.login.LoginScreenActions
import com.example.e_commerce.managers.login.LoginScreenFormStates
import com.example.e_commerce.managers.login.LoginViewModel
import com.example.e_commerce.ui.theme.Blue
import com.example.e_commerce.ui.theme.Gray


@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel<LoginViewModel>(),
) {

    val state = viewModel.uiState.collectAsState().value
    LoginFragment(viewModel)
    when{
        state.isLoading->{
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.secondary,
            )
        }
        state.isSuccess->{
            Toast.makeText(navController.context,"Success", Toast.LENGTH_SHORT).show()
        }
        state.isFailure->{
            Toast.makeText(navController.context,"Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }

}


@Composable
fun LoginFragment(
    viewModel: LoginViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                horizontal = AppPadding.medium
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.route_logo),
            contentDescription = stringResource(R.string.route_logo),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppPadding.x96large, top = AppPadding.x96large)
        )
        Text(
            text = stringResource(R.string.welcome_back_to_route),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = stringResource(R.string.please_sign_in_with_your_email),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Start)
        )
        LoginForm(
            viewModel = viewModel,
            onAction = viewModel::onAction
        )
    }
}


@Composable
fun LoginForm(
    viewModel: LoginViewModel,
    onAction: (LoginScreenActions) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = AppPadding.x40large)
    ) {
        Text(
            text = stringResource(R.string.e_mail_address),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(bottom = AppPadding.large)
        )
        FormTextField(
            value = LoginScreenFormStates.email.value,
            labelText = stringResource(R.string.enter_your_email_address),
            onValueChanged = {
                viewModel.loginScreenFormStates.email.value= it
                viewModel.loginScreenFormStates.emailTouched.value = true
            },
            isError = viewModel.loginScreenFormStates.emailTouched.value && viewModel.isValidEmail() != null,
            errorMessage = viewModel.isValidEmail(),
            isVisible = true
        )
        Text(
            text = stringResource(R.string.password),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(bottom = AppPadding.large, top = AppPadding.large)
        )
        FormTextField(
            value = viewModel.loginScreenFormStates.password.value,
            labelText = stringResource(R.string.enter_your_password),
            trailingIcon = {
                Icon(
                    painterResource(R.drawable.eye),
                    contentDescription = stringResource(R.string.show_password),
                    tint = if(viewModel.loginScreenFormStates.isVisiblePassword.value) Blue else Gray,
                    modifier = Modifier.clickable{
                        onAction(LoginScreenActions.ChangePasswordVisibilityAction)
                    }
                )
            },
            onValueChanged = {
                viewModel.loginScreenFormStates.password.value = it
                viewModel.loginScreenFormStates.passwordTouched.value = true
            },
            isError = viewModel.loginScreenFormStates.passwordTouched.value && viewModel.isValidPassword() != null,
            errorMessage = viewModel.isValidPassword(),
            isVisible = viewModel.loginScreenFormStates.isVisiblePassword.value
        )
        Text(
            text = stringResource(R.string.forget_password),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(top = AppPadding.medium)
                .align(Alignment.End)
        )
        CustomButton(text = stringResource(R.string.login), onClick = {
            onAction(LoginScreenActions.LoginAction)
        })
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
            Text(
                text = stringResource(R.string.don_t_have_an_account),
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily(Font(R.font.poppins_medium))),
                modifier = Modifier
                    .padding(top = AppPadding.medium)
            )
            Text(
                text = stringResource(R.string.create_account),
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily(Font(R.font.poppins_medium))),
                modifier = Modifier
                    .padding(top = AppPadding.medium)
                    .clickable {

                    }
            )
        }
    }
}

//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginFragmentPreview() {
//    EcommerceTheme {
//        LoginFragment()
//    }
//}
