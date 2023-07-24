package com.example.aguafacil.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aguafacil.presentation.screens.FavoriteScreen
import com.example.aguafacil.presentation.screens.HomeScreen
import com.example.aguafacil.presentation.screens.ProfileScreen
import com.example.aguafacil.presentation.screens.ReserveScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavBarScreen.Home.route
    ) {
        composable(route = BottomNavBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavBarScreen.Reserved.route) {
            ReserveScreen()
        }
        composable(route = BottomNavBarScreen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomNavBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}