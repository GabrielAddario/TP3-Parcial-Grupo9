
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.appnectar.R

class Onboarding : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingFunc()
        }
    }
}

@Composable
fun OnboardingFunc() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_onbording),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(350.dp))
            Image(
                painter = painterResource(id = R.drawable.zanahoria_onboarding),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(60.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome",
                        color = White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center

                    )
                Text(
                    text = "to our store",
                    color = White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Ger your groceries in as fast as one hour",
                        color = Gray,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.shadow(4.dp, RoundedCornerShape(4.dp))
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(30),
                        colors = ButtonDefaults.buttonColors(Color(0xFF53B175)),
                        contentPadding = PaddingValues(),
                        modifier = Modifier
                            .size(width = 350.dp, height = 60.dp),
                    ) {
                        Text(
                            text = "Get Started",
                            color = White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.shadow(4.dp)
                        )
                    }
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    OnboardingFunc()
}
