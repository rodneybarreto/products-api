package br.dev.rodneybarreto.minipets.products.domain.dto

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val photo: String
)