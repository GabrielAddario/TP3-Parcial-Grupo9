package com.example.appnectar.navController

import OnboardingPreview
import SplashScreenPreview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnectar.navController.navs.MainScreen
import com.example.appnectar.screens.HomeScreenPreview
import com.example.appnectar.screens.ProductDetailScreenPreview
import com.example.appnectar.screens.SelectLocationScreenPreview
import com.example.appnectar.screens.SignInScreenPreview
import com.example.appnectar.screens.SignUpScreenPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NavController() {
    val navController = rememberNavController()
    val selectBarrio = ""
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") { SplashScreen(navController) }
        composable("onboarding") { OnboardingPreview(navController) }
        composable("sign_in") { SignInScreenPreview(navController) }
        composable("sign_up") { SignUpScreenPreview(navController) }
        composable("location_screen") { SelectLocationScreenPreview(navController) }
        composable("home_screen") { HomeScreenPreview(navController, selectBarrio) }
        composable("main_screen") { MainScreen(navController) }
        composable("product_details/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailScreenPreview(navController = navController, productId)
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        launch {
            delay(2000)
            navController.navigate("onboarding") {
            }
        }
    }
    SplashScreenPreview()
}