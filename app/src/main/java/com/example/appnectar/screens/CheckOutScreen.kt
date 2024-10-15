package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R

@Composable
fun CheckoutScreenPreview(navController: NavController, isDarkModeEnabled: Boolean, totalCost: Double) {
    CheckOutScreen(navController, isDarkModeEnabled, onClose = { navController.navigate("my_cart_screen") }, totalCost)
}

@Composable
fun CheckOutScreen(
    navController: NavController,
    isDarkModeEnabled: Boolean,
    onClose: () -> Unit,
    totalCost: Double
) {
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White
    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val dividerColor = if (isDarkModeEnabled) Color.Gray else Color.LightGray

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            color = backgroundColor,
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(30.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Checkout",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = textColor,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(onClick = onClose),
                    )
                }

                HorizontalDivider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(top = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Delivery", fontSize = 16.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Select Method", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Arrow",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                }
                HorizontalDivider(color = Color.LightGray, modifier = Modifier.padding(top = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Payment", fontSize = 16.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.card_logo),
                        contentDescription = "Card Logo",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Arrow",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                }
                HorizontalDivider(color = Color.LightGray, modifier = Modifier.padding(top = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Promo Code", fontSize = 16.sp, color = Color.Gray, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Pick Discount", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Arrow",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                }

                HorizontalDivider(color = dividerColor, thickness = 2.dp, modifier = Modifier.padding(top = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Total Cost", fontSize = 16.sp, color = textColor, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "$$totalCost", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = textColor)
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = "Arrow",
                        tint = textColor,
                        modifier = Modifier.size(16.dp)
                    )
                }
                HorizontalDivider(color = dividerColor, modifier = Modifier.padding(top = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    buildAnnotatedString {
                        append("By placing an order you agree to our ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = textColor)) {
                            append("Terms")
                        }
                        append(" and ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = textColor)) {
                            append("Conditions")
                        }
                    },
                    fontSize = 13.sp,
                    color = textColor,
                    modifier = Modifier.padding(8.dp)
                )
                Button(
                    onClick = { navigateOrderAccepted(navController) },
                    shape = RoundedCornerShape(30),
                    colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                    contentPadding = PaddingValues(),
                    modifier = Modifier
                        .size(width = 350.dp, height = 60.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    Text(
                        text = "Place Order",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

private fun navigateOrderAccepted(navController: NavController) {
    navController.navigate("order_accepted") {
    }
}