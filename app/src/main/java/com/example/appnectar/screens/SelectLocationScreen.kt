package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R
import com.example.appnectar.dataClass.barrios

@Composable
fun SelectLocationScreenPreview(navController: NavController) {
    SelectLocationScreen(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectLocationScreen(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val barrios = barrios;
    var selectedBarrio by remember { mutableStateOf(barrios[0]) }
    var area by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo_signin),
            contentDescription = "Backgraound Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

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
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(140.dp))
        Text(
            text = "Your Zone",
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Start)
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
                        .clip(RoundedCornerShape(4.dp))
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
                        .clip(RoundedCornerShape(4.dp))
                        .background(color = Color.White)
                ) {
                    barrios.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text, color = Color.Black) },
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
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = area,
            onValueChange = { area = it },
            label = { Text("Area") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .fillMaxWidth()
                .background(Transparent)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = {
                navigateHomeScreen(navController, selectedBarrio)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clip(RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175))
        ) {
            Text(text = "Submit")
            }
        }
    }
}


private fun navigateHomeScreen(navController: NavController, barrio: String) {
    navController.navigate("home_screen") {
    }
}