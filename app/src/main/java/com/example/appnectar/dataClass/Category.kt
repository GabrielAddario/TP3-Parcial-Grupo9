package com.example.appnectar.dataClass

import androidx.compose.ui.graphics.Color
import com.example.appnectar.R

enum class Category(val displayName: String, val imageRes: Int, val color: Color) {
    FRUITS_VEGETABLES("Frash Fruits & Vegetables", R.drawable.fruits_vegetable_categories, Color(
        0xFFD5EED8
    )
    ),
    OIL_GHEE("Cooking Oil & Ghee", R.drawable.oil_ghee_categories, Color(0xFFF5F3CC)),
    MEAT_FISH("Meat & Fish", R.drawable.meat_fish_categories, Color(0xFFFFE2E5)),
    BAKERY_SNACKS("Bakery & Snacks", R.drawable.bakery_snacks_categories, Color(0xFFF3E0FF)),
    DAIRY_EGGS("Dairy & Eggs", R.drawable.eggs_categories, Color(0xFFFFF7D7)),
    BEVERAGES("Beverages", R.drawable.beverages_categories, Color(0xFFE0F4FF)),
    OTHER("Other", R.drawable.fruits_vegetable_categories, Color(0xFFC9B0A1))
}