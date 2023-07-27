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
        startDestination = BottomNavBar.Home.route
    ) {
        composable(route = BottomNavBar.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavBar.Reserved.route) {
            ReserveScreen()
        }
        composable(route = BottomNavBar.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomNavBar.Profile.route) {
            ProfileScreen()
        }
    }
}