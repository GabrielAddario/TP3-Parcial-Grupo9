package com.example.appnectar.screens


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appnectar.R
import com.example.appnectar.client.RetrofitClient
import com.example.appnectar.client.model.UserListItem
import retrofit2.Call
import retrofit2.Callback

@Composable
fun SignUpScreenPreview(navController: NavController) {
    SignUpScreen(navController)
}

@Composable
private fun SignUpScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Transparent)

    ){
        Image(
            painter = painterResource(id = R.drawable.fondo_signin),
            contentDescription = "Carrot Logo",
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Image(
                painter = painterResource(id = R.drawable.zanahoria_signin),
                contentDescription = "Carrot Logo",
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(150.dp))

            Text(
                text = "Sign Up",
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Enter your credentials to continue",
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium,
                color = Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Transparent),
            )

            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Transparent),
            )

            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "By continuing you agree to our Terms of Service and Privacy Policy.",
                color = Gray,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { }
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    RetrofitClient.instance.createUser(username, email, password).enqueue(object: Callback<UserListItem> {
                        override fun onResponse(
                            call: retrofit2.Call<UserListItem>,
                            response: retrofit2.Response<UserListItem>
                        ) {
                            if (response.isSuccessful && username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                                Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                                navController.navigate("sign_in")
                            } else {
                                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<UserListItem>, t: Throwable) {
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    })
                },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                contentPadding = PaddingValues(),
                modifier = Modifier.size(width = 350.dp, height = 60.dp)
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 16.sp,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(text = "Already have an account?", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Medium,)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "SignIn",
                    color = Color(0xFF53B175),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navigateSignIn(navController) }
                )
            }
        }
    }
}


private fun navigateSignIn(navController: NavController) {
    navController.navigate("sign_in") {
    }
}
