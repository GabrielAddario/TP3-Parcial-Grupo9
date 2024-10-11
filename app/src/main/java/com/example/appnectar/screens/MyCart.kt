package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.appnectar.R
import com.example.appnectar.dataClass.Product
import com.example.appnectar.navController.navs.TopNavbar
import com.example.appnectar.dataClass.MyCarts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCartScreen(navController: NavHostController) {
    val products = MyCarts // Use the product list from FakeData
    val colorDivider = Color(0xFFE2E2E2)

    Scaffold(
        topBar = { TopNavbar("My Cart") },
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = colorDivider, thickness = 1.dp)
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(products) { product ->
                        ProductCard(product = product)
                        HorizontalDivider(thickness = 1.dp, color = colorDivider)
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
                Text(text = "Track Order", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}


@Composable
fun ProductCard(product: Product) {
    val quantity = remember { mutableStateOf(product.cant) }
    var cont = 1

    Card(
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .width(363.dp)
            .height(150.dp) // Adjusted height to accommodate larger images
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
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = product.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Start
                    )
                    Image(
                        painter = painterResource(id = R.drawable.boton_cerrar),
                        contentDescription = "Close Button",
                        modifier = Modifier
                            .size(15.dp)
                            .clickable { /* Add close action here */ }
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "${product.cant}${product.typeSizes}, Price",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    lineHeight = 14.sp,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.boton_mycart_menos),
                        contentDescription = "Decrease Quantity",
                        modifier = Modifier
                            .size(45.dp)
                            .clickable { if (cont > 0) cont-- }
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Increased space
                    Text(
                        text = "${cont}",
                        fontSize = 16.sp, // Adjusted font size
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Increased space
                    Image(
                        painter = painterResource(id = R.drawable.boton_mycart_mas),
                        contentDescription = "Increase Quantity",
                        modifier = Modifier
                            .size(45.dp)
                            .clickable { if (cont > 10) cont++ }
                    )
                    Spacer(modifier = Modifier.padding(25.dp))
                    Text(
                        text = "$${product.price}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        lineHeight = 27.sp,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@Composable
fun MyCartScreenPreview(navController: NavHostController) {
    MyCartScreen(navController = navController)
}