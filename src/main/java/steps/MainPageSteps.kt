package steps

import com.codeborne.selenide.Selenide
import io.qameta.allure.Step
import pages.MainPage

class MainPageSteps {
    private val url = "http://google.com"

    private val mainPage: MainPage = MainPage()

    @Step("Open {url}")
    fun openMainPage(): MainPageSteps {
        Selenide.open(url)
        return this
    }

    @Step("Check the search is visible")
    fun checkSearchVisible(): MainPageSteps {
        mainPage.checkSearchVisible()
        return this
    }

}