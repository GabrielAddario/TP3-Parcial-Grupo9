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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SignInScreenPreview(navController: NavController) {
    SignInScreen(navController)
}

@Composable
fun SignInScreen(navController: NavController) {
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
               text = "Sign In",
               fontWeight = FontWeight.Medium,
               fontSize = 30.sp,
               modifier = Modifier.fillMaxWidth(),
               textAlign = TextAlign.Start
           )

           Spacer(modifier = Modifier.height(15.dp))

           Text(
               text = "Enter your emails and password",
               fontSize = 19.sp,
               fontWeight = FontWeight.Medium,
               color = Color.Gray,
               modifier = Modifier.fillMaxWidth(),
               textAlign = TextAlign.Start
           )

           Spacer(modifier = Modifier.height(16.dp))

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

           Spacer(modifier = Modifier.height(16.dp))

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

           Spacer(modifier = Modifier.height(20.dp))

           Text(
               text = "Forgot Password?",
               color = Color.Gray,
               fontSize = 14.sp,
               modifier = Modifier
                   .align(Alignment.End)
                   .clickable { }
           )

           Spacer(modifier = Modifier.height(20.dp))

           Button(
               onClick = {loginUser(email, password, context, navController) },
               shape = RoundedCornerShape(30),
               colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
               contentPadding = PaddingValues(),
               modifier = Modifier
                   .size(width = 350.dp, height = 60.dp),
           ) {
               Text(
                   text = "Log In",
                   fontSize = 16.sp,
               )
           }

           Spacer(modifier = Modifier.height(16.dp))

           Row {
               Text(text = "Don't have an account?", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Medium,)
               Spacer(modifier = Modifier.width(4.dp))
               Text(
                   text = "Signup",
                   color = Color(0xFF53B175),
                   fontWeight = FontWeight.Bold,
                   modifier = Modifier.clickable { navigateSignUp(navController)}
               )
           }
       }
   }
}

fun loginUser(email: String, password: String, context: android.content.Context, navController: NavController) {
    if (email == "mor_2314" && password == "83r5^_") {
        Toast.makeText(context, "Login successful!", Toast.LENGTH_LONG).show()
        navController.navigate("location_screen")
    } else {
        Toast.makeText(context, "Invalid credentials.", Toast.LENGTH_SHORT).show()
    }
}

fun navigateSignUp(navController: NavController) {
    navController.navigate("sign_up") {
    }
}
