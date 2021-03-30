package br.dev.rodneybarreto.minipets.products.service.impl

import br.dev.rodneybarreto.minipets.products.domain.dto.Product
import br.dev.rodneybarreto.minipets.products.domain.repository.ProductRepository
import br.dev.rodneybarreto.minipets.products.service.ProductService
import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import java.io.File
import java.nio.file.Files

@Service
class ProductServiceImpl(
    @Autowired
    val productRepository: ProductRepository
): ProductService {

    @Value("\${spring.profiles.active}")
    lateinit var activeProfile: String

    override fun findAll(): List<Product> {
        val products = mutableListOf<Product>()
        productRepository.findAll().map {
            val product = Product(it.id, it.name, it.description, it.price, toBase64(it.photo))
            products.add(product)
        }
        return products.toList()
    }

    private fun toBase64(photo: String): String {
        if (activeProfile.equals("dev")) {
            val file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + photo)
            val bytes = Files.readAllBytes(file.toPath())
            return Base64.encodeBase64String(bytes)
        } else {
            val file = File(photo)
            val bytes = Files.readAllBytes(file.toPath())
            return Base64.encodeBase64String(bytes)
        }
    }

}