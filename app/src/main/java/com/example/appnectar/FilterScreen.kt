package com.example.appnectar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FilterScreen() {
    var categoriesState by remember { mutableStateOf(listOf(false, false, false, false)) }
    var brandsState by remember { mutableStateOf(listOf(false, false, false, false)) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco para la primera columna
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
                    .background(Color.White) // Fondo blanco para el encabezado
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Acción para cerrar */ }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Cerrar")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Filters", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Nested Column for the rest of the content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color(0xFFeeeeee),
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    ) // Fondo blanco eeeeee con esquinas superiores redondeadas
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
                            Text(text = "Categories", style = MaterialTheme.typography.bodyLarge, fontSize = 22.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            val categories = listOf("Eggs", "Noodles & Pasta", "Chips & Crisps", "Fast Food")
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
                                    Text(
                                        text = category,
                                        fontSize = 18.sp,
                                        color = if (categoriesState[index]) Color(0xFF00A86B) else Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre los elementos de la checklist
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
                            Text(text = "Brand", style = MaterialTheme.typography.bodyLarge, fontSize = 22.sp)
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
                                    Text(
                                        text = brand,
                                        fontSize = 18.sp,
                                        color = if (brandsState[index]) Color(0xFF00A86B) else Color.Black
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre los elementos de la checklist
                            }
                        }
                    }

                    // Spacer to add space between content and button
                    Spacer(modifier = Modifier.height(210.dp))

                    // Apply Filter Button at the bottom
                    Button(
                        onClick = { /* Apply filter action */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A86B)) // Color verde para el botón
                    ) {
                        Text(text = "Apply Filter")
                    }

                    // Box to select the white space below the button and make it light gray
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .background(Color(0xFFeeeeee))
                    )
                }
            }
        }
    }
}

@Composable
fun RoundedCornerCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?
) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = Modifier.background(Color.Transparent, shape = RoundedCornerShape(4.dp)),
        colors = CheckboxDefaults.colors(checkedColor = Color(0xFF00A86B)) // Color verde para el tilde
    )
}

@Composable
@Preview(showBackground = true)
fun FilterScreenPreview() {
    FilterScreen()
}