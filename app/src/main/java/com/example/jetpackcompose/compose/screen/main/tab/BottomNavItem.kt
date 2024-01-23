package com.example.jetpackcompose.compose.screen.main.tab

import com.example.jetpackcompose.R

sealed class BottomNavItem(
    val title: Int, val icon: Int, val screenRoute: String
) {
    object First: BottomNavItem(title = R.string.bottom_first, icon = R.drawable.ic_action_home, screenRoute = FirstScreenRoute.route)
    object Second: BottomNavItem(title = R.string.bottom_second, icon = R.drawable.ic_action_shop, screenRoute = SecondScreenRoute.route)
    object Third: BottomNavItem(title = R.string.bottom_third, icon = R.drawable.ic_action_wallet, screenRoute = ThirdScreenRoute.route)
}