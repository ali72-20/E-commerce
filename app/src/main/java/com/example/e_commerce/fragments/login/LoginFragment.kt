package com.example.e_commerce.fragments.login

import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
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
import com.example.e_commerce.core.AppRadius
import com.example.e_commerce.core.navigation.Register
import com.example.e_commerce.managers.login.LoginScreenActions
import com.example.e_commerce.managers.login.LoginScreenStates
import com.example.e_commerce.managers.login.LoginViewModel
import com.example.e_commerce.ui.theme.Gray


@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel<LoginViewModel>(),
) {
    when(viewModel.state){
        LoginScreenStates(navigateToRegister = true) -> navController.navigate(Register)
    }
    LoginFragment(viewModel)
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
            state = viewModel.state,
            onAction = viewModel::onAction
        )
    }
}


@Composable
fun LoginForm(
    state: LoginScreenStates,
    onAction: (LoginScreenActions) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = AppPadding.x40large)
    ) {
        Text(
            text = stringResource(R.string.user_name),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(bottom = AppPadding.large)
        )
        FormTextField(
            stringResource(R.string.enter_your_name),
        )
        Text(
            text = stringResource(R.string.password),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(bottom = AppPadding.large, top = AppPadding.large)
        )
        FormTextField(
            stringResource(R.string.enter_your_password),
            trailingIcon = {
                Icon(
                    painterResource(R.drawable.eye),
                    contentDescription = stringResource(R.string.show_password),
                    tint = Gray
                )
            }
        )
        Text(
            text = stringResource(R.string.forget_password),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(top = AppPadding.medium)
                .align(Alignment.End)
        )
        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppPadding.large),
            shape = RoundedCornerShape(AppRadius.formRadius),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier.padding(top = AppPadding.small, bottom = AppPadding.small)
            )
        }
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
                        onAction(LoginScreenActions.GoToRegisterAction)
                    }
            )
        }
    }
}

@Composable
fun FormTextField(labelText: String, trailingIcon: (@Composable (() -> Unit))? = null) {
    TextField(
        shape = RoundedCornerShape(AppRadius.formRadius),
        value = "",
        textStyle = MaterialTheme.typography.labelSmall,
        onValueChange = {},
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelSmall
            )
        },
        trailingIcon = trailingIcon?.let { { it() } },
        modifier = Modifier.fillMaxWidth(),

        )
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoginFragmentPreview() {
//    EcommerceTheme {
//        LoginFragment()
//    }
//}
