package com.example.aguafacil.components

import androidx.annotation.DrawableRes
import com.example.aguafacil.R

sealed class BottomNavBarScreen(
    val route: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavBarScreen(
        route = "home",
        icon = R.drawable.icon_home
    )

    object Reserved : BottomNavBarScreen(
        route = "reserved",
        icon = R.drawable.icon_reserved
    )

    object Favorite : BottomNavBarScreen(
        route = "favorite",
        icon = R.drawable.icon_favorite
    )

    object Profile : BottomNavBarScreen(
        route = "profile",
        icon = R.drawable.icon_profile
    )
}
