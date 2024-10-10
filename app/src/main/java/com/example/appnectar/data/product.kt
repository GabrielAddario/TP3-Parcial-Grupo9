package com.example.appnectar.data

import androidx.compose.runtime.Immutable

@Immutable
data class Product(
    val id: Int,
    val image: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: com.example.appnectar.data.Category,
    val cant: Int,
    val typeSizes: TypeSizes,
    val stock: Int = 0
)