package com.example.appnectar.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R
import androidx.compose.ui.window.DialogProperties

@Composable
private fun ErrorPopUp(
    onRetry: () -> Unit,
    onBackToHome: () -> Unit,
    showDialog: Boolean,
    onDismiss: () -> Unit,
    isDarkModeEnabled: Boolean
) {
    val textColor = if (isDarkModeEnabled) Color.White else Color.Black
    val backgroundColor = if (isDarkModeEnabled) Color(0xFF1E1E1E) else Color.White

    if (showDialog) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(dismissOnClickOutside = false, usePlatformDefaultWidth = false)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(600.dp)
                    .padding(16.dp)
                    .background(Color.Transparent),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                elevation = CardDefaults.cardElevation(8.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopStart
                    ) {
                        IconButton(onClick = onRetry) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close"
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.error_logo),
                        contentDescription = "Error Icon",
                        modifier = Modifier
                            .width(222.dp)
                            .height(222.dp)
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Oops! Order Failed",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = textColor
                    )
                    Text(
                        text = "Something went tembly wrong.",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(36.dp))

                    Button(
                        onClick = onRetry,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .width(67.dp),
                        shape = RoundedCornerShape(19.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF53B175))
                    ) {
                        Text(text = "Please Try Again", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(onClick = onBackToHome) {
                        Text(text = "Back to home", color = textColor)
                    }
                }
            }
        }
    }
}

//@Preview
@Composable
fun ErrorScreenPreview(navController: NavController, isDarkModeEnabled: Boolean) {
    var showErrorDialog by remember { mutableStateOf(true) }
    ErrorPopUp(
        onRetry = { navController.navigate("favourite_screen")
             },
        onBackToHome = {
            navController.navigate("home_screen")
                       },
        showDialog = showErrorDialog,
        onDismiss = { showErrorDialog = false},
        isDarkModeEnabled = isDarkModeEnabled
    )
}