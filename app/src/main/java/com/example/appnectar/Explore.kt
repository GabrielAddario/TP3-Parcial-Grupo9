package com.example.appnectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appnectar.data.Product
import com.example.appnectar.data.ProductListItems
import com.example.appnectar.navs.TopNavbar

class Explore : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploreContent()
        }
    }
}

@Composable
fun ExploreContent() {
    Scaffold(
        topBar = { TopNavbar("Find Products") },
        //bottomBar = { BottomNavbar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues).padding(16.dp)
        ) {
            item {
                Text("Search Store", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
            }
            items(ProductListItems) { item ->
                ProductItem(item)
            }
        }
    }
}

@Composable
fun ProductItem(item: Product) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(item.title, fontSize = 16.sp)
        Text("${item.price}", fontSize = 14.sp, color = Color.Gray)
    }
}


@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    ExploreContent()
}

