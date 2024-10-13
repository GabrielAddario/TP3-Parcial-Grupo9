      package com.example.appnectar.screens

import androidx.compose.foundation.Image
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
import com.example.appnectar.navController.navs.TopNavbar


@Composable
private fun FavoritesScreen(navController: NavController) {
    val products = FavoriteItems // Use the product list from FakeData
    val colorDivider = Color(0xFFE2E2E2)

    Scaffold(
        topBar = { TopNavbar("Favorites") },
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = colorDivider, thickness = 1.dp)
                LazyColumn(
                    //verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(products) { product ->
                        CardProduct(product = product)
                        Divider(color = colorDivider, thickness = 1.dp)
                    }
                }
            }
            Button(
                onClick = { /* Acción para rastrear pedido */ },
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .size(width = 350.dp, height = 60.dp),
            ) {
                Text(text = "Add All To Cart", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Composable
private fun CardProduct(product: Product) {
    Card(
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .width(363.dp)
            .height(100.dp) // Adjusted height
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = product.title,
                modifier = Modifier.size(70.dp) // Increased size
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
                    color = Color.Black,
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
                    color = Color.Black,
                    lineHeight = 27.sp,
                    textAlign = TextAlign.End
                )
                IconButton(onClick = { /* Add action here */ }) {
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

@Composable
fun FavoritesScreenPreview(navController: NavController) {
    FavoritesScreen(navController)
}