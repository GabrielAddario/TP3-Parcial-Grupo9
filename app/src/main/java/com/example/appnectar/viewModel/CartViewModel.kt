package com.example.appnectar.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnectar.dataClass.MyCarts
import com.example.appnectar.dataClass.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _totalCost = MutableStateFlow(0.0)
    val totalCost: StateFlow<Double> = _totalCost

    init {
        viewModelScope.launch {
            _products.value = MyCarts
            calculateTotalCost()
        }
    }

    private fun calculateTotalCost() {
        _totalCost.value = _products.value.sumOf { it.price }
    }
}