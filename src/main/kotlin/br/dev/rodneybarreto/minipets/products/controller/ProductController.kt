package br.dev.rodneybarreto.minipets.products.controller

import br.dev.rodneybarreto.minipets.products.domain.dto.Product
import br.dev.rodneybarreto.minipets.products.service.ProductService
import br.dev.rodneybarreto.minipets.products.util.log.Logging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/products")
class ProductController(
    @Autowired
    val productService: ProductService
): Logging {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun findAll(): ResponseEntity<List<Product>> {
        logger().info("find all products")
        val products = productService.findAll()
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.ok(products)
    }

}