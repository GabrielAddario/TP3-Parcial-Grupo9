package com.example.appnectar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appnectar.navs.TopNavbar
import com.example.appnectar.ui.theme.AppNectarTheme

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
    //@androidx.compose.runtime.Composable { TopNavbar("Shop List") }
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        item {
            Text("Search Store", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
        }
        item {
            CategorySection("Fresh Fruits & Vegetables")
        }
        item {
            CategorySection("Cooking Oil & Ghee")
        }
        item {
            CategorySection("Bakery & Snacks")
        }
        item {
            CategorySection("Beverages")
        }
        item {
            CategorySection("Meat & Fish")
        }
        item {
            CategorySection("Dairy & Eggs")
        }
    }
}

@Composable
fun CategorySection(title: String) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(title, fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
        // Aquí puedes agregar una lista de productos para cada categoría
        // Por ejemplo:
       // items(sampleItems) { item ->
        //    ProductItem(item)
        //}
    }
}

@Composable
fun ProductItem(item: Product) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(item.name, fontSize = 16.sp)
        Text("${item.price}", fontSize = 14.sp, color = Color.Gray)
    }
}

data class Product(val name: String, val price: String)

val sampleItems = listOf(
    Product("Product 1", "$1.99"),
    Product("Product 2", "$2.99"),
    Product("Product 3", "$3.99")
)


@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    ExploreContent()
}

