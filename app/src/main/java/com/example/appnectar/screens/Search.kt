package com.example.appnectar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import com.example.appnectar.dataClass.Product
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.appnectar.R
import com.example.appnectar.dataClass.SearchCarts
import com.example.appnectar.navController.navs.TopNavbar

@Composable
fun ProductListScreenPreview(navController: NavHostController, searchQuery: String) {
    ProductListScreen(navController, searchQuery)
}

@Composable
private fun ProductListScreen(navController: NavHostController, searchQuery: String) {
    val products = SearchCarts // Lista completa de productos
    val filteredProducts = products.filter { product ->
        // Filtra por título o descripción
        product.title.contains(searchQuery, ignoreCase = true) ||
                product.description.contains(searchQuery, ignoreCase = true) // Asegúrate de que tu clase Product tenga un campo description
    }

    Scaffold(
        topBar = { TopNavbar("Search") },
        bottomBar = { }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            SearchBar(searchText = remember { mutableStateOf(TextFieldValue(searchQuery)) }) // Inicializa la barra de búsqueda
            Spacer(modifier = Modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f)
            ) {
                items(filteredProducts) { product -> // Muestra la lista filtrada
                    CardProduct(product = product)
                }
            }
        }
    }
}

@Composable
fun SearchBar(searchText: MutableState<TextFieldValue>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F0F0), shape = CircleShape)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done // Cambia a Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Evitar salto de línea al presionar Enter
                    // Aquí no se hace nada
                }
            ),
            decorationBox = { innerTextField ->
                if (searchText.value.text.isEmpty()) {
                    Text(text = "Buscar productos", color = Color.Gray)
                }
                innerTextField()
            }
        )
    }
}

@Composable
private fun CardProduct(product: Product) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen del producto
            Image(
                painter = painterResource(id = product.image),
                contentDescription = "Product Image",
                modifier = Modifier.size(90.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Nombre del producto
            Text(
                text = product.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.padding(2.dp))

            // Detalles del producto
            Text(
                text = "${product.cant}${product.typeSizes}, Price",
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.padding(8.dp))

            // Precio y botón de agregar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$${product.price}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    lineHeight = 27.sp,
                    textAlign = TextAlign.End
                )

                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(Color(0xFF4CAF50), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.boton_agregar), // Replace with your button image resource
                        contentDescription = "Button",
                        modifier = Modifier
                            .size(45.dp)
                            .clickable { /* Hay que agregar el producto al carrito*/ }
                    )
                }
            }
        }
    }
}