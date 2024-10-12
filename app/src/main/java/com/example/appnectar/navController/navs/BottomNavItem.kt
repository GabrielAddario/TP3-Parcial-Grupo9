package com.example.appnectar.navController.navs

import com.example.appnectar.R

sealed class BottomNavItem(val route: String, val iconResId: Int, val iconResIdSelected: Int, val title: String) {
    data object Shop : BottomNavItem("home_screen", R.drawable.shop_logo, R.drawable.shop_logo_green, "Shop")
    data object Explore : BottomNavItem("explore_screen", R.drawable.explore_logo, R.drawable.explore_logo_green, "Explore")
    data object Cart : BottomNavItem("my_cart_screen", R.drawable.cart_logo, R.drawable.cart_logo_green, "Cart")
    data object Favourite : BottomNavItem("favourite_screen", R.drawable.favourite_logo, R.drawable.favourite_logo_green, "Favourite")
    data object Account : BottomNavItem("account_screen", R.drawable.account_logo, R.drawable.account_logo_green, "Account")
}