package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.example.appnectar.dataClass.FavoriteItems
import com.example.appnectar.dataClass.Product
import com.example.appnectar.navController.navs.BottomNavBar
import com.example.appnectar.navController.navs.TopNavbar

@Composable
fun FavouriteScreen(navController: NavController, isDarkModeEnabled: Boolean) {
    val products = FavoriteItems
    val colorDivider = Color(0xFFE2E2E2)

    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White



    Scaffold(
        topBar = { TopNavbar("Favorites", isDarkModeEnabled) },
        bottomBar = {  BottomNavBar(navController)  }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(paddingValues)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = colorDivider, thickness = 1.dp)
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(products) { product ->
                        CardProduct(navController, product, textColor, backgroundColor)
                        HorizontalDivider(thickness = 1.dp, color = colorDivider)
                    }
                }
            }
            Button(
                onClick = { navigateErrorScreen(navController) },
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
                    .size(width = 350.dp, height = 60.dp),
            ) {
                Text(text = "Add All To Cart", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun CardProduct(navController: NavController, product: Product, textColor: Color, backgroundColor: Color) {
    Card(
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .width(363.dp)
            .height(100.dp)
            .padding(vertical = 8.dp)
            .clickable {navigateProductDetails(navController, product.id)  },
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
                verticalArrangement = Arrangement.Center,
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
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "${product.cant}${product.typeSizes}, Price",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    lineHeight = 14.sp,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
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

private fun navigateProductDetails(navController: NavController, productId: Int) {
    navController.navigate("product_details/$productId")
}

private fun navigateErrorScreen(navController: NavController) {
    navController.navigate("error_screen")
}

@Composable
fun FavouriteScreenPreview(navController: NavController, isDarkModeEnabled: Boolean) {
    FavouriteScreen(navController, isDarkModeEnabled )
}