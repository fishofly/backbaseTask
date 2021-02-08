package steps.rest

import io.qameta.allure.Step
import io.restassured.http.ContentType
import io.restassured.response.Response
import org.apache.http.HttpStatus
import org.junit.Assert
import utils.PropertyService.Companion.getBaseUrl
import utils.RequestService.Companion.getRequest
import utils.TestAccount
import kotlin.random.Random

class UserManagementSteps {
    private val password = "Testpass2"

    @Step("Create new test account")
    fun createTestAccount(): TestAccount {
        val user = "testuser${Random.nextInt(1000, 9999)}"
        val email = "$user@test.ru"
        val response: Response =
            getRequest()
                .baseUri(getBaseUrl() + "/api/users")
                .body("{\"user\":{\"username\":\"$user\",\"email\":\"$email\",\"password\":\"$password\"}}")
                .contentType(ContentType.JSON)
                .post()
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode())
        return TestAccount(email, this.password)
    }
}