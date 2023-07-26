package com.example.aguafacil.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.aguafacil.components.DashboardScreen
import com.example.aguafacil.ui.theme.WaterEasyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterEasyTheme {
                DashboardScreen()
            }
        }
    }
}
