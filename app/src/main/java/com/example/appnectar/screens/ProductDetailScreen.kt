package com.example.appnectar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.dataClass.ProductListItems

@Composable
fun ProductDetailScreenPreview(
    navController: NavController, productId: String?, isDarkModeEnabled: Boolean
) {
    ProductDetailScreen(navController, productId, isDarkModeEnabled)
}

@Composable
fun Counter(textColor: Color) {
    var count by remember { mutableStateOf(1) }
    IconButton(onClick = { if (count > 1) count-- }) {
        Icon(Icons.Filled.Remove, contentDescription = "Remove", tint = textColor)
    }
    Text(text = count.toString(), fontSize = 18.sp, color = textColor)
    IconButton(onClick = { count++ }) {
        Icon(Icons.Filled.Add, contentDescription = "Add", tint = textColor)
    }
}

@Composable
fun FavoriteButton() {
    var isFavorite by remember { mutableStateOf(false) }

    IconButton(onClick = { isFavorite = !isFavorite }) {
        Icon(
            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = if (isFavorite) "Unfavorite" else "Favorite",
            tint = if (isFavorite) Color.Red else Color.Gray
        )
    }
}

@Composable
private fun ProductDetailScreen(navController: NavController, productId: String?, isDarkModeEnabled: Boolean) {
    val product = ProductListItems.find { it.id.toString() == productId }
    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White

    product?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                    contentDescription = "Arrow",
                    tint = textColor,
                    modifier = Modifier
                        .size(18.dp)
                        .clickable { navigateHomeScreen(navController) }
                        .align(Alignment.TopStart)
                )

                Text(
                    text = "Product Detail",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = it.image),
                    contentDescription = it.title,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(150.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = it.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${it.cant} ${it.typeSizes}, Price",
                        fontSize = 16.sp,
                        color = textColor.copy(alpha = 0.7f)
                    )
                }
                FavoriteButton()
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Counter(textColor)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$${it.price}",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Divider(color = textColor.copy(alpha = 0.5f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Product Details",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = it.description,
                fontSize = 14.sp,
                color = textColor.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Divider(color = textColor.copy(alpha = 0.5f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Nutritions",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.LightGray)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "100gr",
                        fontSize = 14.sp,
                        color = textColor.copy(alpha = 0.7f)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Box {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Arrow",
                        tint = textColor,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Divider(color = textColor.copy(alpha = 0.5f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Reviews",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        repeat(5) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Star",
                                tint = Color(0xFFFFA500),
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                            contentDescription = "Arrow",
                            tint = textColor,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Divider(color = textColor.copy(alpha = 0.5f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(70.dp))

            Button(
                onClick = { navigateMyCart(navController) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(67.dp),
                shape = RoundedCornerShape(19.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175))
            ) {
                Text(text = "Add To Basket", fontSize = 16.sp)
            }
        }
    }
}

private fun navigateHomeScreen(navController: NavController) {
    navController.navigate("home_screen") {
    }
}

private fun navigateMyCart(navController: NavController) {
    navController.navigate("my_cart_screen") {
    }
}