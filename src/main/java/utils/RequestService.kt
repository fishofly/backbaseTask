package utils

import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured.given
import io.restassured.specification.RequestSpecification

class RequestService {
    companion object {
        private val creds = TestCredentialsService.getAccessCredentials()

        @JvmStatic
        fun getRequest(): RequestSpecification {
            return given()
                .filter(AllureRestAssured())
                .relaxedHTTPSValidation()
                .auth()
                .basic(creds.login, creds.password)
        }
    }
}