package com.example.aguafacil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.aguafacil.components.DashboardScreen
import com.example.aguafacil.ui.theme.WaterEasyTheme

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
