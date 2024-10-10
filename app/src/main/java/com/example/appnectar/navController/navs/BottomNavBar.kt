package com.example.appnectar.navController.navs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

class BottomNavbar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavbarContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavbarContent() {
    /*
    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_cart), contentDescription = "Cart") },
                    label = { Text("Cart") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_shop), contentDescription = "Shop") },
                    label = { Text("Shop") },
                    selected = true,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_explore), contentDescription = "Explore") },
                    label = { Text("Explore") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_account), contentDescription = "Account") },
                    label = { Text("Account") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
            }
        }
    ) {
        // Content of the screen
    }*/
}

@Preview(showBackground = true)
@Composable
fun BottomNavbarPreview() {
    BottomNavbarContent()
}