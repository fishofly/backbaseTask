package rest

import BasicTest
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured.given
import io.restassured.specification.RequestSpecification

open class BasicRestTest : BasicTest() {

    companion object {

        @JvmStatic
        fun getRequest(): RequestSpecification {
            return given().filter(AllureRestAssured())
        }
    }
}