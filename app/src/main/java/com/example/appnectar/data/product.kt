package com.example.appnectar.data

import androidx.compose.runtime.Immutable

@Immutable
data class Product(
    val id: Int,
    val image: String,
    val title: String,
    val price: Double,
    val description: String,
    val cant: Int,
    val typeSizes: TypeSizes,
    val stock: Int = 0
)