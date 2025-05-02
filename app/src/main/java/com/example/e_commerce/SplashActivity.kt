package com.example.e_commerce

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.e_commerce.ui.theme.Blue
import com.example.e_commerce.ui.theme.EcommerceTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommerceTheme {
                Handler(mainLooper).postDelayed({
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 2500)
                SplashActivityContent()
            }
        }
    }
}


@Composable
fun SplashActivityContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painterResource(R.drawable.splash_top),
            contentDescription = stringResource(R.string.splash_top),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painterResource(R.drawable.route_logo),
            contentDescription = stringResource(R.string.splash_logo),
            contentScale = ContentScale.Crop,
        )
        Image(
            painterResource(R.drawable.splash_bottom),
            contentDescription = stringResource(R.string.splash_bottom),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashActivityPreview() {
    SplashActivityContent()
}