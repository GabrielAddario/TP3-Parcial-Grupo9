package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R


@Composable
fun SelectLocationScreenPreview(navController: NavController) {
    SelectLocationScreen(navController)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLocationScreen(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val barrios = listOf(
        "Palermo", "Recoleta", "Belgrano", "San Telmo", "Caballito", "Villa Urquiza",
        "Villa Devoto", "Almagro", "Boedo", "Flores", "Villa Crespo", "Retiro",
        "Puerto Madero", "Constitución", "Barracas", "Parque Patricios", "Chacarita",
        "Villa Lugano", "Villa Luro", "Mataderos", "Liniers", "Parque Chas", "Villa del Parque"
    )
    var selectedBarrio by remember { mutableStateOf(barrios[0]) }
    var area by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_ubicacion),
            contentDescription = "Logo Ubicacion",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Select Your Location",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Switch on your location to stay in tune with what’s happening in your area",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Your Zone",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    modifier = Modifier
                        .menuAnchor()
                        .clip(RoundedCornerShape(4.dp)) // Less rounded corners
                        .background(color = Color.White)
                        .fillMaxWidth(),
                    value = selectedBarrio,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    }
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp)) // Less rounded corners
                        .background(color = Color.White)
                ) {
                    barrios.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = {
                                selectedBarrio = barrios[index]
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Your Area",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = area,
                    onValueChange = { area = it },
                    label = { Text("Area") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Transparent),
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {navigateHomeScreen(navController)},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp) // Adjust the height of the button
                .clip(RoundedCornerShape(0.dp)), // Less rounded corners
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175)) // Set button color to green
        ) {
            Text(text = "Submit")
        }
    }
}

fun navigateHomeScreen(navController: NavController) {
    navController.navigate("onboarding") {
    }
}