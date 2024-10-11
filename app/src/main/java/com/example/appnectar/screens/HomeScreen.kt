package com.example.appnectar.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.example.appnectar.dataClass.BestSelling
import com.example.appnectar.dataClass.ExclusiveOffer
import com.example.appnectar.dataClass.Product
import com.example.appnectar.navController.navs.BottomNavBar
import com.example.appnectar.navController.navs.TopNavbar


@Composable
fun HomeScreenPreview(navController: NavController, barrio: String) {
    HomeScreenContent(navController, barrio)
}

@Composable
fun HomeScreenContent(navController: NavController, barrio: String) {
    var searchQuery by remember { mutableStateOf("") }
    Scaffold(
        topBar = { TopNavbar("Shop") },
        bottomBar = { BottomNavBar(navController) } // Agregar la BottomNavBar aquí
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)) {

            Text(
                text = barrio,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Imagen de banner_homescreen
            Image(
                painter = painterResource(id = R.drawable.banner_homescreen),
                contentDescription = "Home Screen Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    //.height(200.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Exclusive Offer",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                ExclusiveOffer.forEach { product ->
                    ProductCard(product, navController)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Best Selling",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                BestSelling.forEach { product ->
                    ProductCard(product, navController)
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, navController: NavController) {
    Card(
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .width(173.32.dp)
            .height(248.51.dp)
            .padding(end = 8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(18.dp))
            .clickable { navigateProductDetails(navController, product.id) },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                lineHeight = 18.sp,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${product.cant} ${product.typeSizes}, Priceg",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray,
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
                    color = Color.Black,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(8.dp)) // Adjusted Spacer width
                Image(
                    painter = painterResource(id = R.drawable.boton_agregar), // Replace with your button image resource
                    contentDescription = "Button",
                    modifier = Modifier
                        .size(45.dp)
                        .clickable { /* Hay que agregar el producto al carrito*/ }
                )
            }
        }
    }
}

fun navigateProductDetails(navController: NavController, productId: Int) {
    navController.navigate("product_details/$productId")
}

