package com.example.appnectar.navController.navs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

class TopNavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopNavbar(titleText = String(), isDarkModeEnabled = false)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavbar(titleText: String, isDarkModeEnabled: Boolean) {
    var expanded by remember { mutableStateOf(false) }
    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Tobias, Calvo") },
                        onClick = { }
                    )
                    DropdownMenuItem(
                        text = { Text("Gabriel, Addario") },
                        onClick = { }
                    )
                    DropdownMenuItem(
                        text = { Text("Roman, Luraschi") },
                        onClick = { }
                    )
                }
                Spacer(modifier = Modifier.weight(0.25f))
                Text(
                    titleText,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = textColor
                )
                Spacer(modifier = Modifier.weight(0.5f))
            }
        }
    )
    HorizontalDivider(color = Color.Gray, thickness = 1.dp)
}


@Composable
fun TopNavbarPreview() {
    TopNavbar(titleText = String(), isDarkModeEnabled = false)
}