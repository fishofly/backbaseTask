package rest

import io.qameta.allure.Feature
import io.qameta.allure.Story
import io.restassured.response.Response
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
@Feature("Test sample API call")
class RestSampleTest(private val city: String, private val expectedCode: Int) : BasicRestTest() {

    private val apiKey = "22e41b5c8cf5c120f474dc72a7eb760c" //to be nicely placed in a config file

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("London", 200),
            arrayOf("noplace", 404)
        )
    }

    @Test
    @Story("Validate status code per city")
    fun checkWeatherApi() {
        val response: Response =
            getRequest()
                .baseUri("http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey")
                .get()
        Assert.assertEquals(expectedCode, response.statusCode());
    }
}