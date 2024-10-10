package com.example.appnectar.data

import androidx.compose.ui.graphics.Color
import com.example.appnectar.R

enum class Category(val displayName: String, val imageRes: Int, val color: Color) {
    FRUITS_VEGETABLES("Frash Fruits & Vegetables", R.drawable.fruits_vegetable_categories, Color(0xB253B175)),
    OIL_GHEE("Cooking Oil & Ghee", R.drawable.oil_ghee_categories, Color(0xB2F8A44C)),
    MEAT_FISH("Meat & Fish", R.drawable.meat_fish_categories, Color(0xFFF7A593)),
    BAKERY_SNACKS("Bakery & Snacks", R.drawable.bakery_snacks_categories, Color(0xFFD3B0E0)),
    DAIRY_EGGS("Dairy & Eggs", R.drawable.eggs_categories, Color(0xFFFDE598)),
    BEVERAGES("Beverages", R.drawable.beverages_categories, Color(0xFFB7DFF5)),
    OTHER("Other", R.drawable.fruits_vegetable_categories, Color(0xF8A44C1A))
}