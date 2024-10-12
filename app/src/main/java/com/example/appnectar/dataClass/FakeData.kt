package com.example.appnectar.dataClass

import com.example.appnectar.R

val ProductListItems = listOf(
    Product(1, R.drawable.banana, "Banana", 30.5, "Test description 1", Category.FRUITS_VEGETABLES, 2, TypeSizes.kg, 10),
    Product(2, R.drawable.pepsi, "Pepsi", 15.0, "Test description 1", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(3, R.drawable.egg_chicken_white, "Huevos", 24.5, "Test description 1", Category.DAIRY_EGGS,6, TypeSizes.pcs, 10),
    Product(4, R.drawable.morron, "Morron", 29.5, "Test description 1", Category.FRUITS_VEGETABLES,1, TypeSizes.kg, 10),
    Product(5, R.drawable.sprite, "Sprite", 15.0, "Lata de Sprite", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(6, R.drawable.coca, "Coca-Cola", 15.0, "Lata de Coca-Cola", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(7, R.drawable.coca_diet, "Coca-Cola Diet", 17.5, "Lata de Coca-Cola Diet", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(8, R.drawable.jugo_manzana, "Jugo Manzana", 19.5, "Jugo de Manzana", Category.BEVERAGES,750, TypeSizes.ml, 10),
    Product(9, R.drawable.mayonesa, "Mayonesa", 34.5, "Mayonesa", Category.OTHER ,1, TypeSizes.kg, 10),
    Product(10, R.drawable.fideos, "Fideos", 32.0, "Fideos", Category.OTHER,1, TypeSizes.kg, 10),
    Product(11, R.drawable.manzana, "Manzana", 45.0, "Manzana", Category.FRUITS_VEGETABLES,2, TypeSizes.kg, 10),
)

val FavoriteItems = listOf(
    Product(5, R.drawable.sprite, "Sprite", 15.0, "Lata de Sprite", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(7, R.drawable.coca_diet, "Coca-Cola Diet", 17.5, "Lata de Coca-Cola Diet", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(8, R.drawable.jugo_manzana, "Jugo Manzana", 19.5, "Jugo de Manzana", Category.BEVERAGES,750, TypeSizes.ml, 10),
    Product(6, R.drawable.coca, "Coca-Cola", 15.0, "Lata de Coca-Cola", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(2, R.drawable.pepsi, "Pepsi", 15.0, "Test description 1", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(3, R.drawable.egg_chicken_white, "Huevos", 24.5, "Test description 1", Category.DAIRY_EGGS,6, TypeSizes.pcs, 10),
    Product(9, R.drawable.mayonesa, "Mayonesa", 34.5, "Mayonesa", Category.OTHER ,1, TypeSizes.kg, 10),
    Product(10, R.drawable.fideos, "Fideos", 32.0, "Fideos", Category.OTHER,1, TypeSizes.kg, 10),
    Product(11, R.drawable.manzana, "Manzana", 45.0, "Manzana", Category.FRUITS_VEGETABLES,2, TypeSizes.kg, 10),
)

val ExclusiveOffer = listOf(
    Product(1, R.drawable.banana, "Banana", 27.5, "Test description 1", Category.FRUITS_VEGETABLES, 2, TypeSizes.kg, 10),
    Product(10, R.drawable.manzana, "Manzana", 45.0, "Manzana", Category.FRUITS_VEGETABLES,2, TypeSizes.kg, 10),
    Product(2, R.drawable.pepsi, "Pepsi", 15.0, "Test description 1", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(4, R.drawable.morron, "Morron", 29.5, "Test description 1", Category.FRUITS_VEGETABLES,1, TypeSizes.kg, 10),
    Product(5, R.drawable.sprite, "Sprite", 15.0, "Lata de Sprite", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(9, R.drawable.mayonesa, "Mayonesa", 34.5, "Mayonesa", Category.OTHER ,1, TypeSizes.kg, 10),
    Product(10, R.drawable.fideos, "Fideos", 32.0, "Fideos", Category.OTHER,1, TypeSizes.kg, 10),
)

val BestSelling = listOf(
    Product(4, R.drawable.morron, "Morron", 29.5, "Test description 1", Category.FRUITS_VEGETABLES,1, TypeSizes.kg, 10),
    Product(7, R.drawable.coca_diet, "Coca-Cola Diet", 17.5, "Lata de Coca-Cola Diet", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(8, R.drawable.jugo_manzana, "Jugo Manzana", 19.5, "Jugo de Manzana", Category.BEVERAGES,750, TypeSizes.ml, 10),
    Product(9, R.drawable.mayonesa, "Mayonesa", 34.5, "Mayonesa", Category.OTHER ,1, TypeSizes.kg, 10),
    Product(10, R.drawable.fideos, "Fideos", 32.0, "Fideos", Category.OTHER,1, TypeSizes.kg, 10),
)

val MyCarts = listOf(
    Product(4, R.drawable.morron, "Morron", 29.5, "Test description 1", Category.FRUITS_VEGETABLES,1, TypeSizes.kg, 10),
    Product(3, R.drawable.egg_chicken_white, "Huevos", 24.5, "Test description 1", Category.DAIRY_EGGS,6, TypeSizes.pcs, 10),
    Product(1, R.drawable.banana, "Banana", 27.5, "Test description 1", Category.FRUITS_VEGETABLES, 2, TypeSizes.kg, 10),
    Product(2, R.drawable.pepsi, "Pepsi", 15.0, "Test description 1", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(5, R.drawable.sprite, "Sprite", 15.0, "Lata de Sprite", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(7, R.drawable.coca_diet, "Coca-Cola Diet", 17.5, "Lata de Coca-Cola Diet", Category.BEVERAGES,350, TypeSizes.ml, 10),
    Product(9, R.drawable.mayonesa, "Mayonesa", 34.5, "Mayonesa", Category.OTHER ,1, TypeSizes.kg, 10),
    Product(10, R.drawable.fideos, "Fideos", 32.0, "Fideos", Category.OTHER,1, TypeSizes.kg, 10),
)

val SearchCarts = listOf(
    Product(4, R.drawable.egg_chicken_white, "Egg Chicken Red", 29.5, "4", Category.DAIRY_EGGS,1, TypeSizes.pcs, 10),
    Product(3, R.drawable.manzana, "Manzana", 24.5, "180", Category.FRUITS_VEGETABLES,6, TypeSizes.g, 10),
    Product(1, R.drawable.fideos, "Egg Pasta", 27.5, "30", Category.FRUITS_VEGETABLES, 2, TypeSizes.gm, 10),
    Product(2, R.drawable.morron, "Morron", 10.0, "21", Category.FRUITS_VEGETABLES,350, TypeSizes.kg, 10),
    Product(5, R.drawable.banana, "Banana", 15.0, "300", Category.FRUITS_VEGETABLES,350, TypeSizes.kg, 10),
    Product(4, R.drawable.egg_chicken_white, "Egg Chicken Red", 29.5, "220", Category.DAIRY_EGGS,1, TypeSizes.pcs, 10),
)