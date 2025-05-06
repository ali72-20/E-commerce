package com.example.e_commerce.fragments.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.e_commerce.R
import com.example.e_commerce.core.AppPadding
import com.example.e_commerce.ui.theme.EcommerceTheme

@Composable
fun RegisterFragment() {
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
        )
        RegisterForm()
    }
}


@Composable
fun RegisterForm() {
    Column(){

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    EcommerceTheme {
        RegisterFragment()
    }
}
