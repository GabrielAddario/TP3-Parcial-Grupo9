package com.example.appnectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.appnectar.navController.NavController
import com.example.appnectar.ui.theme.AppNectarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val isDarkModeEnabled = remember { mutableStateOf(false) }
            AppNectarTheme(isDarkModeEnabled.value) {
                NavController(isDarkModeEnabled.value) { isDarkModeEnabled.value = it }
            }
        }
    }
}