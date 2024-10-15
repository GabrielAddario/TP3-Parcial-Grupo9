package com.example.appnectar.screens

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appnectar.dataClass.Category
import com.example.appnectar.navController.navs.TopNavbar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavController
import com.example.appnectar.navController.navs.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ExploreContent(navController: NavController, isDarkModeEnabled: Boolean) {
    var searchQuery by remember { mutableStateOf("") }
    val textColor = if (isDarkModeEnabled) Color.Black else Color.Black

    Scaffold(
        topBar = { TopNavbar("Find Categories", isDarkModeEnabled)},
        bottomBar = { BottomNavBar(navController)}
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search Store", fontSize = 15.sp, fontWeight = FontWeight.Light, color = textColor) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clickable {  navigateSearch(navController) },
                shape = RoundedCornerShape(8.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 12.sp, color = textColor),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = textColor
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { navigateFilters(navController) }) {
                        Icon(
                            imageVector = Icons.Default.Tune,
                            contentDescription = "Settings Icon",
                            tint = textColor
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFF5F5F5),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = textColor
                )
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(Category.values().filter { it.name.contains(searchQuery, ignoreCase = true) }) { category ->
                    CategoryCard(
                        navController = navController,
                        category = category,
                        textColor = textColor
                    )
                }
            }
        }
    }
}

@Composable
private fun CategoryCard(category: Category, navController: NavController, textColor: Color) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(175.5.dp)
            .height(189.11.dp)
            .padding(8.dp)
            .clickable { navigateToCategory(navController, category) },
        colors = CardDefaults.cardColors(containerColor = category.color)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.displayName,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    category.displayName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = textColor
                )
            }
        }
    }
}

private fun navigateFilters(navController: NavController) {
    navController.navigate("filters")
}

private fun navigateSearch(navController: NavController) {
    navController.navigate("search_screen")
}

private fun navigateToCategory(navController: NavController, category: Category) {
    navController.navigate("categories_screen/${category.name}")
}

@Composable
fun ExplorePreview(navController: NavController, isDarkModeEnabled: Boolean) {
    ExploreContent(navController, isDarkModeEnabled)
}