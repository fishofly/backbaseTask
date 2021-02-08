package utils

import java.io.InputStream
import java.util.*

class PropertyService {
    companion object {
        private var fis: InputStream =
            this::class.java.getClassLoader().getResourceAsStream("test.properties")
        private val properties = Properties()

        init {
            properties.load(fis)
        }

        fun getBaseUrl(): String {
            return checkNotNull(properties.getProperty("baseUrl")) { "No baseUrl in $fis" }
        }
    }
}