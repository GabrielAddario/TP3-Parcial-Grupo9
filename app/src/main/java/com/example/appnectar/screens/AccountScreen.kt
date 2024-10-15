package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import com.example.appnectar.R
import androidx.navigation.NavController


@Composable
fun AccountScreen(navController : NavController, isDarkModeEnabled: Boolean, onDarkModeToggle: (Boolean) -> Unit) {
    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val colorDivider = Color(0xFFE2E2E2)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(24.dp))
            Column {
                Text(text = "Afsar Hossen", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = textColor)
                Text(text = "lmshuvo97@gmail.com", fontSize = 16.sp, color = textColor)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        HorizontalDivider(color = colorDivider, thickness = 2.dp)
        MenuItem(icon = R.drawable.ic_orders, label = "Orders", textColor = textColor)
        Divider(color = colorDivider, thickness = 1.dp)
        MenuItem(icon = R.drawable.ic_details, label = "My Details", textColor = textColor)
        Divider(color = colorDivider, thickness = 1.dp)
        MenuItem(icon = R.drawable.ic_address, label = "Delivery Address", textColor = textColor)
        Divider(color = colorDivider, thickness = 1.dp)
        MenuItem(icon = R.drawable.ic_payment, label = "Payment Methods", textColor = textColor)
        Divider(color = colorDivider, thickness = 1.dp)
        MenuItem(icon = R.drawable.ic_promo, label = "Promo Cord", textColor = textColor)
        Divider(color = colorDivider, thickness = 1.dp)
        MenuItem(icon = R.drawable.ic_notifications, label = "Notifications", textColor = textColor)
        Divider(color = colorDivider, thickness = 1.dp)
        MenuItem(icon = R.drawable.ic_help, label = "Help", textColor = textColor)
        Divider(color = colorDivider, thickness = 1.dp)


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Dark mode", fontSize = 20.sp, color = textColor, modifier = Modifier.padding(start = 45.dp))
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = isDarkModeEnabled,
                onCheckedChange = onDarkModeToggle,
                colors = SwitchDefaults.colors(
                    uncheckedTrackColor = Color.LightGray,
                    checkedTrackColor = Color.Black,
                    uncheckedThumbColor = Color.LightGray,
                    checkedThumbColor = Color.White,
                )
            )
        }
        Divider(color = colorDivider, thickness = 1.dp)

        Spacer(modifier = Modifier.padding(vertical = 15.dp))

        Button(
            onClick = { navigateSignIn(navController) },
            modifier = Modifier
                .width(364.dp)
                .height(67.dp),
            shape = RoundedCornerShape(30),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(Color(0xFFE0E0E0))
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_exit),
                        contentDescription = "Log Out",
                        tint = Color(0xFF53B175),
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "Log Out",
                    fontSize = 20.sp,
                    color = Color(0xFF53B175),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun MenuItem(icon: Int, label: String, textColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = icon), tint = textColor, contentDescription = label, modifier = Modifier.size(28.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label, fontSize = 20.sp, color = textColor, modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.arrow_forward),
            contentDescription = "Forward Button",
            modifier = Modifier.size(8.4.dp, 14.dp)
        )
    }
}

@Composable
fun AccountScreenPreview(navController: NavController, isDarkModeEnabled: Boolean, onDarkModeToggle: (Boolean) -> Unit) {
    AccountScreen(navController, isDarkModeEnabled, onDarkModeToggle)
}

private fun navigateSignIn(navController: NavController) {
    navController.navigate("sign_in") {
    }
}