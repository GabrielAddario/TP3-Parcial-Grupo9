package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R
import com.example.appnectar.dataClass.Category
import com.example.appnectar.dataClass.Product
import com.example.appnectar.dataClass.ProductListItems

@Composable
fun CategoriesScreenPreview(
    navController: NavController, category: Category,  isDarkModeEnabled: Boolean
) {
    CategoriesScreenPreview(navController, category, isDarkModeEnabled)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsByCategoryScreen(navController: NavController, category: Category, isDarkModeEnabled: Boolean) {
    val products = ProductListItems.filter { it.category == category }
    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = category.displayName,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Acción del botón atrás */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = "Back",
                            tint = textColor,
                            modifier = Modifier
                                .size(18.dp)
                                .clickable { navigateHomeScreen(navController) }
//                                .align(Alignment.TopStart)
                        )
                    }
                },
            )
        },
        bottomBar = { }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(8.dp),
            ) {
                items(products) { product ->
                    ProductCard(product = product, navController, textColor, backgroundColor)
                }
            }
        }
    }
}

@Composable
private fun ProductCard(product: Product, navController: NavController, textColor: Color, backgroundColor: Color) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clickable { navigateProductDetails(navController, product.id) },
                contentAlignment = Alignment.Center
            ) {
                // Imagen del producto
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Nombre del producto
            Text(
                text = product.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.padding(2.dp))

            // Detalles del producto
            Text(
                text = "${product.cant}${product.typeSizes}, Price",
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.padding(8.dp))

            // Precio y botón de agregar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${product.price}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    lineHeight = 27.sp,
                    textAlign = TextAlign.End
                )

                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(Color(0xFF4CAF50), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.boton_agregar), // Replace with your button image resource
                        contentDescription = "Button",
                        modifier = Modifier
                            .size(45.dp)
                            .clickable { navigateMyCart(navController) },
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProductsByCategoryScreenPreview() {
//    ProductsByCategoryScreen(category = Category.BEVERAGES)
//}

private fun navigateHomeScreen(navController: NavController) {
    navController.navigate("home_screen") {
    }
}

private fun navigateProductDetails(navController: NavController, productId: Int) {
    navController.navigate("product_details/$productId")
}

private fun navigateMyCart(navController: NavController) {
    navController.navigate("my_cart_screen") {
    }
}