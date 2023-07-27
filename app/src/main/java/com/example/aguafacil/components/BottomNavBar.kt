package com.example.aguafacil.components

import androidx.annotation.DrawableRes
import com.example.aguafacil.R

sealed class BottomNavBar(
    val route: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavBar(
        route = "home",
        icon = R.drawable.icon_home
    )

    object Reserved : BottomNavBar(
        route = "reserved",
        icon = R.drawable.icon_reserved
    )

    object Favorite : BottomNavBar(
        route = "favorite",
        icon = R.drawable.icon_favorite
    )

    object Profile : BottomNavBar(
        route = "profile",
        icon = R.drawable.icon_profile
    )
}
