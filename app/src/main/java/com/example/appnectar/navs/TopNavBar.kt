package com.example.appnectar.navs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

class TopNavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopNavbar(titleText = String())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavbar(titleText: String) {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
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
                        text = { Text("Opción 1") },
                        onClick = { /* Acción */ }
                    )
                    DropdownMenuItem(
                        text = { Text("Opción 2") },
                        onClick = { /* Acción */ }
                    )
                }
                Spacer(modifier = Modifier.weight(0.25f))
                Text(
                    titleText,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(0.5f))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TopNavbarPreview() {
    TopNavbar(titleText = String())
}