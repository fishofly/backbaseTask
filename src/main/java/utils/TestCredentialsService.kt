package utils

import com.codeborne.selenide.Credentials

class TestCredentialsService {
    companion object {
        val username: String = checkNotNull(System.getProperty("testuser"))
        { "Provide testuser" }
        val password: String = checkNotNull(System.getProperty("testpassword"))
        { "Provide testpassword" }

        public fun getAccessCredentials(): Credentials {
            return Credentials(username, password)
        }
    }
}