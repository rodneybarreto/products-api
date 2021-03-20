package br.dev.rodneybarreto.minipets.products.util.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Logging {
    fun <T: Any> T.logger(): Logger = LoggerFactory.getLogger(javaClass)
}