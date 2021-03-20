package br.dev.rodneybarreto.minipets.products.domain.repository

import br.dev.rodneybarreto.minipets.products.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Int> {
}