package br.dev.rodneybarreto.minipets.products.service

import br.dev.rodneybarreto.minipets.products.domain.dto.Product

interface ProductService {

    fun findAll(): List<Product>

}