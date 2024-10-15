package com.example.appnectar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.dataClass.Categories

@Composable
private fun FilterScreen(navController: NavController, isDarkModeEnabled: Boolean) {
    var categoriesState by remember { mutableStateOf(listOf(false, false, false, false)) }
    var brandsState by remember { mutableStateOf(listOf(false, false, false, false)) }
    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White
    val headerBackgroundColor = if (isDarkModeEnabled) Color(0xFF2C2C2C) else Color.White
    val contentBackgroundColor = if (isDarkModeEnabled) Color(0xFF2C2C2C) else Color(0xFFeeeeee)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(headerBackgroundColor)
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp)
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Color.Gray,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 15.dp)
                            .clickable { navigateExploreScreen(navController) }
                            .align(Alignment.TopStart)
                    )

                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = "Filters",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        color = textColor
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nested Column for the rest of the content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = contentBackgroundColor,
                        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                    )
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(bottom = 16.dp)
                ) {
                    // Categories Section
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                text = "Categories",
                                style = MaterialTheme.typography.bodyLarge,
                                fontSize = 30.sp,
                                color = textColor
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            val categories = Categories
                            categories.forEachIndexed { index, category ->
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    RoundedCornerCheckbox(
                                        checked = categoriesState[index],
                                        onCheckedChange = { isChecked ->
                                            categoriesState = categoriesState.toMutableList().apply {
                                                this[index] = isChecked
                                            }
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        text = category,
                                        fontSize = 18.sp,
                                        color = if (categoriesState[index]) Color(0xFF53B175) else textColor
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Brand Section
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Column {
                            Text(
                                text = "Brand",
                                style = MaterialTheme.typography.bodyLarge,
                                fontSize = 30.sp,
                                color = textColor
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            val brands = listOf("Individual Collection", "Cocola", "Ifad", "Kazi Farmas")
                            brands.forEachIndexed { index, brand ->
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    RoundedCornerCheckbox(
                                        checked = brandsState[index],
                                        onCheckedChange = { isChecked ->
                                            brandsState = brandsState.toMutableList().apply {
                                                this[index] = isChecked
                                            }
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        text = brand,
                                        fontSize = 18.sp,
                                        color = if (brandsState[index]) Color(0xFF00A86B) else textColor
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre los elementos de la checklist
                            }
                        }
                    }

                    // Spacer to add space between content and button
                    Spacer(modifier = Modifier.height(220.dp))

                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                        contentPadding = PaddingValues(),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(width = 350.dp, height = 60.dp),
                    ) {
                        Text(
                            text = "Apply Filter",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    // Box to select the white space below the button and make it light gray
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .background(contentBackgroundColor)
                    )
                }
            }
        }
    }
}

private fun navigateExploreScreen(navController: NavController) {
    navController.navigate("explore_screen") {
    }
}

@Composable
private fun RoundedCornerCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
) {
    Box(
        modifier = Modifier
            .size(30.dp) // Tamaño del contenedor del checkbox
            .clickable { onCheckedChange?.invoke(!checked) }
            .padding(4.dp)
    ) {
        // Fondo redondeado
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(color = if (checked) Color(0xFF53B175) else Color.Transparent)
                .border(width = 2.dp, color = Color.LightGray)
        )

        Checkbox(
            checked = checked,
            onCheckedChange = null,
            modifier = Modifier
                .size(30.dp)
                .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp)),
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Transparent,
                uncheckedColor = Color.Transparent,
                checkmarkColor = Color.White
            )
        )
    }
}

@Composable
fun FilterScreenPreview(navController: NavController, isDarkModeEnabled: Boolean) {
    FilterScreen(navController, isDarkModeEnabled)
}