package web

import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.Test
import steps.MainPageSteps

@Feature("Test sample web page")
class WebHeaderTest : BasicWebTest() {

    private val mainPageSteps: MainPageSteps = MainPageSteps() //to be nicely replaced by some spring config

    @Test
    @Story("Validate search is visible")
    fun checkSearch() {
        mainPageSteps.openMainPage()
            .checkSearchVisible()
    }
}