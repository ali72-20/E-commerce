package com.example.e_commerce.fragments.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.e_commerce.R
import com.example.e_commerce.core.AppPadding
import com.example.e_commerce.core.navigation.Login
import com.example.e_commerce.core.shard_compose.CustomButton
import com.example.e_commerce.core.shard_compose.FormTextField
import com.example.e_commerce.managers.register.RegisterActions
import com.example.e_commerce.managers.register.RegisterScreenStates
import com.example.e_commerce.managers.register.RegisterViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel<RegisterViewModel>(),
    navController: NavController
) {

    when (viewModel.state) {
        RegisterScreenStates(navigateToLoginState = true) -> {
            navController.navigate(Login)
        }
    }

    RegisterFragment(
        onAction = viewModel::onAction
    )
}

@Composable
fun RegisterFragment(
    onAction: (RegisterActions) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(AppPadding.medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.route_logo),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.route_logo),
            modifier = Modifier.padding(top = AppPadding.x64large)
        )
        RegisterForm()
        Spacer(
            modifier = Modifier.padding(bottom = AppPadding.x48large)
        )
        CustomButton(text = stringResource(R.string.sign_up), onClick = {})
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
            Text(
                text = stringResource(R.string.already_have_account),
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily(Font(R.font.poppins_medium))),
                modifier = Modifier
                    .padding(top = AppPadding.medium)
            )
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily(Font(R.font.poppins_medium))),
                modifier = Modifier
                    .padding(top = AppPadding.medium)
                    .clickable {
                        onAction(RegisterActions.NavigateToLoginAction)
                    }
            )
        }
    }
}


@Composable
fun RegisterForm() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        Text(
            text = stringResource(R.string.full_name),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = AppPadding.x48large, bottom = AppPadding.medium)
        )
        FormTextField(
            labelText = stringResource(R.string.enter_your_full_name),
            value = "",
            onValueChanged = {},
            isError = false,
            isVisible = true,
            errorMessage = null
        )
        Text(
            stringResource(R.string.mobile_number),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = AppPadding.large, bottom = AppPadding.medium)

        )
        FormTextField(
            labelText = stringResource(R.string.enter_your_mobile_no),
            value = "",
            onValueChanged = {

            },
            isError = false,
            isVisible = true,
            errorMessage = null
        )
        Text(
            stringResource(R.string.e_mail_address),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = AppPadding.large, bottom = AppPadding.medium)
        )
        FormTextField(
            labelText = stringResource(R.string.enter_your_email_address),
            value = "",
            onValueChanged = {

            },
            isError = false,
            errorMessage = null,
            isVisible = true
        )
        Text(
            stringResource(R.string.password),
            modifier = Modifier.padding(top = AppPadding.large, bottom = AppPadding.medium)
        )
        FormTextField(
            value = "",
            onValueChanged = {},
            isError = false,
            errorMessage = null,
            isVisible = true,
            labelText = stringResource(R.string.enter_your_password),
            trailingIcon = {
                Icon(
                    painterResource(R.drawable.eye),
                    contentDescription = stringResource(R.string.show_password)
                )
            })
    }
}

//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RegisterScreenPreview() {
//    EcommerceTheme {
//        RegisterFragment()
//    }
//}
