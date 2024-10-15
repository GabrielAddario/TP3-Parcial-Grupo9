package com.example.appnectar.navController

import OnboardingPreview
import SplashScreenPreview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnectar.dataClass.Category
import com.example.appnectar.navController.navs.MainScreen
import com.example.appnectar.screens.AccountScreenPreview
import com.example.appnectar.screens.CheckoutScreenPreview
import com.example.appnectar.screens.ErrorScreenPreview
import com.example.appnectar.screens.ExplorePreview
import com.example.appnectar.screens.FavouriteScreenPreview
import com.example.appnectar.screens.FilterScreenPreview
import com.example.appnectar.screens.HomeScreenPreview
import com.example.appnectar.screens.MyCartScreenPreview
import com.example.appnectar.screens.PreviewOrderAcceptedScreen
import com.example.appnectar.screens.ProductDetailScreenPreview
import com.example.appnectar.screens.ProductListScreenPreview
import com.example.appnectar.screens.ProductsByCategoryScreen
import com.example.appnectar.screens.SelectLocationScreenPreview
import com.example.appnectar.screens.SignInScreenPreview
import com.example.appnectar.screens.SignUpScreenPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NavController(isDarkModeEnabled: Boolean, onDarkModeToggle: (Boolean) -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") { SplashScreen(navController) }
        composable("onboarding") { OnboardingPreview(navController) }
        composable("sign_in") { SignInScreenPreview(navController) }
        composable("sign_up") { SignUpScreenPreview(navController) }
        composable("location_screen") { SelectLocationScreenPreview(navController) }
        composable("home_screen") { HomeScreenPreview(navController, isDarkModeEnabled) }
        composable("main_screen") { MainScreen(navController) }
        composable("my_cart_screen") { MyCartScreenPreview(navController, isDarkModeEnabled) }
        composable("explore_screen") { ExplorePreview(navController, isDarkModeEnabled) }
        composable("favourite_screen") { FavouriteScreenPreview(navController, isDarkModeEnabled) }
        composable("product_details/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailScreenPreview(navController = navController, productId, isDarkModeEnabled)
        }
        composable("checkout_screen/{totalCost}") { backStackEntry ->
            val totalCost = backStackEntry.arguments?.getString("totalCost")?.toDoubleOrNull() ?: 0.0
            CheckoutScreenPreview(navController, isDarkModeEnabled, totalCost)
        }
        composable("order_accepted") { PreviewOrderAcceptedScreen(navController) }
        composable("filters") { FilterScreenPreview(navController, isDarkModeEnabled) }
        composable("account_screen") {
            MainScreen(navController) {
                AccountScreenPreview(navController, isDarkModeEnabled, onDarkModeToggle)
            }
        }
        composable("search_screen") { ProductListScreenPreview(navController, isDarkModeEnabled) }
        composable("categories_screen/{category}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("category")
            val category = categoryName?.let { Category.valueOf(it) } ?: Category.OTHER
            ProductsByCategoryScreen(navController, category, isDarkModeEnabled)
        }
        composable("error_screen") { ErrorScreenPreview(navController, isDarkModeEnabled) }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        launch {
            delay(2000)
            navController.navigate("onboarding") {
                popUpTo("splash_screen") { inclusive = true }
            }
        }
    }
    SplashScreenPreview()
}