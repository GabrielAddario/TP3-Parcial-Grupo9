package com.example.appnectar.dataClass

import androidx.compose.runtime.Immutable

@Immutable
data class Product(
    val id: Int,
    val image: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: Category,
    val cant: Int,
    val typeSizes: TypeSizes,
    val stock: Int = 0
)