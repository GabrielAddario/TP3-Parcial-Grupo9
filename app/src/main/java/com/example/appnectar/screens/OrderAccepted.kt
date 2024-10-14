package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R

//@Preview(showBackground = true)
@Composable
fun PreviewOrderAcceptedScreen(navController: NavController, isDarkModeEnabled: Boolean) {
    OrderAcceptedScreen(navController)
}

@Composable
private fun OrderAcceptedScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Transparent)
    ){
        Image(
            painter = painterResource(id = R.drawable.fondo_order_accepted),
            contentDescription = "Fondo Order Accepted",
            modifier = Modifier
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_order_accepted),
                contentDescription = "Order Accepted",
                modifier = Modifier
                    .size(250.dp)
                    .padding(bottom = 20.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Your Order has been accepted",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            // Texto secundario
            Text(
                text = "Your items has been placed and is on it's way to being processed",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 32.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(150.dp))

            Button(
                onClick = { navigateHomeScreen(navController) },
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .size(width = 350.dp, height = 60.dp),
            ) {
                Text(text = "Track Order", color = Color.White, fontSize = 16.sp)
            }

            Text(
                text = "Back to home",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 16.dp)
                                    .clickable { navigateHomeScreen(navController) },
            )
        }
    }
}

private fun navigateHomeScreen(navController: NavController) {
    navController.navigate("home_screen") {
    }
}

