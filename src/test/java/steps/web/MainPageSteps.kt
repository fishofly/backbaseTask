package steps.web

import com.codeborne.selenide.AuthenticationType
import com.codeborne.selenide.Selenide
import io.qameta.allure.Step
import pages.LoginPage
import pages.MainPage
import utils.PropertyService.Companion.getBaseUrl
import utils.TestCredentialsService.Companion.getAccessCredentials

class MainPageSteps {

    private val mainPage: MainPage = MainPage()
    private val loginPage: LoginPage = LoginPage()

    @Step("Open main page")
    fun openMainPage(): MainPageSteps {
        Selenide.open(getBaseUrl(), AuthenticationType.BASIC, getAccessCredentials())
        return this
    }

    @Step("Perform login")
    fun login(testAccountEmail: String, testAccountPass: String): MainPageSteps {
        Selenide.open(getBaseUrl() + "/#/login")
        loginPage
            .performLogin(testAccountEmail, testAccountPass)
            .verifyLoginSuccessful(testAccountEmail)
        return this
    }

    fun createTestArticle(articleTitle: String): MainPageSteps {
        mainPage.openNewArticlePage()
            .createNewArticle(articleTitle)
            .verifyArticleCreated(articleTitle)
        return this
    }

    fun openFirstArticle() {
        mainPage.openGlobalFeed()
            .openFirstArticle()
    }
}