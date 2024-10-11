package com.example.appnectar.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appnectar.dataClass.Category
import com.example.appnectar.navController.navs.TopNavbar
/*
class Explore : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploreContent(navController)
        }
    }
}

 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreContent(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    Scaffold(
        topBar = { TopNavbar("Find Categories") },
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search Categories", fontSize = 15.sp, fontWeight = FontWeight.Light) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 12.sp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(Category.entries.filter { it.name.contains(searchQuery, ignoreCase = true) }) { category ->
                    CategoryCard(
                        category = category,
                        color = getCategoryColor(category),
                        onClick = { /* Navegar a la ruta específica */ }
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category, color: Color, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(175.5.dp)
            .height(189.11.dp)
            .padding(8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = category.color)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(), // Fill the card size
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.displayName,
                modifier = Modifier.size(64.dp), // Adjust the size as needed
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp)) // Add space between image and text
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    category.displayName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center // Center the text within the box
                )
            }
        }
    }
}

fun onClick() {
    TODO("Not yet implemented")
}

@Composable
fun getCategoryColor(category: Category): Color {
    return when (category) {
        Category.FRUITS_VEGETABLES -> Color.Green
        Category.OIL_GHEE -> Color.Yellow
        Category.MEAT_FISH -> Color.Red
        Category.BAKERY_SNACKS -> Color.Magenta
        Category.DAIRY_EGGS -> Color.Blue
        Category.BEVERAGES -> Color.Cyan
        Category.OTHER -> Color.Gray
    }
}

@Composable
fun ExplorePreview(navController: NavHostController) {
    ExploreContent(navController)
}