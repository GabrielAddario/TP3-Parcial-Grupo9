package com.example.appnectar.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R
import com.example.appnectar.dataClass.Product
import com.example.appnectar.navController.navs.TopNavbar
import com.example.appnectar.dataClass.MyCarts
import com.example.appnectar.navController.navs.BottomNavBar

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyCartScreen(navController: NavController, isDarkModeEnabled: Boolean) {
    val products = MyCarts
    val colorDivider = Color(0xFFE2E2E2)
    var showCheckoutScreen by remember { mutableStateOf(false) }

    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White

    Scaffold(
        topBar = { TopNavbar("My Cart") },
        bottomBar = { BottomNavBar(navController) }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = colorDivider, thickness = 1.dp)
                LazyColumn(
                    modifier = Modifier.weight(1f).align(Alignment.CenterHorizontally)
                ) {
                    items(products) { product ->
                        ProductCard(product, textColor, backgroundColor, navController)
                        HorizontalDivider(thickness = 1.dp, color = colorDivider)
                    }
                }
            }
            Button(
                onClick = { showCheckoutScreen = true },
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
                    .size(width = 350.dp, height = 60.dp),
            ) {
                Text(text = "Go to Checkout", color = Color.White, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            visible = showCheckoutScreen,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it })
        ) {
            CheckOutScreen(navController = navController)
        }
    }
}

@Composable
private fun ProductCard(product: Product, textColor: Color, backgroundColor: Color, navController: NavController) {
    Card(
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .width(363.dp)
            .height(150.dp)
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.title,
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = product.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${product.cant} ${product.typeSizes}, Price",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = textColor,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "$${product.price}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = textColor,
                        lineHeight = 27.sp,
                        textAlign = TextAlign.End
                    )
                    IconButton(onClick = { navigateProductDetails(navController, product.id) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_forward),
                            contentDescription = "Forward Button",
                            modifier = Modifier.size(8.4.dp, 12.dp)
                        )
                    }
                }
            }
        }
    }
}

private fun navigateProductDetails(navController: NavController, productId: Int) {
    navController.navigate("product_details/$productId")
}

@Composable
fun MyCartScreenPreview(navController: NavController, isDarkModeEnabled: Boolean) {
    MyCartScreen(navController, isDarkModeEnabled)
}