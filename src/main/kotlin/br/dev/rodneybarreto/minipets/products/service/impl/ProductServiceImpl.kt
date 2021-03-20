package br.dev.rodneybarreto.minipets.products.service.impl

import br.dev.rodneybarreto.minipets.products.domain.dto.Product
import br.dev.rodneybarreto.minipets.products.domain.repository.ProductRepository
import br.dev.rodneybarreto.minipets.products.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    @Autowired
    val productRepository: ProductRepository
): ProductService {

    override fun findAll(): List<Product> {
        val products = mutableListOf<Product>()
        productRepository.findAll().map {
            val product = Product(it.id, it.name, it.description, it.price, it.photo)
            products.add(product)
        }
        return products.toList()
    }

}