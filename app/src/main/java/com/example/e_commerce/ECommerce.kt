package com.example.e_commerce

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ECommerce : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}