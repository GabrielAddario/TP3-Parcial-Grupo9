package com.example.appnectar.navController.navs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    data object Shop : BottomNavItem("home_screen", Icons.Filled.Storefront, "Shop")
    data object Explore : BottomNavItem("explore_screen", Icons.Filled.Search, "Explore")
    data object Cart : BottomNavItem("my_cart_screen", Icons.Filled.ShoppingCart, "Cart")
    data object Favourite : BottomNavItem("favourite_screen", Icons.Filled.Favorite,"Favourite")
    data object Account : BottomNavItem("account_screen", Icons.Filled.AccountBox, "Account")
}