package web

import BasicTest
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.AfterClass
import org.junit.BeforeClass

open class BasicWebTest : BasicTest() {

    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {
            SelenideLogger.addListener(
                "AllureSelenide", AllureSelenide().screenshots(true).savePageSource(true)
            )
            Configuration.browser = "chrome"
            Configuration.startMaximized = true
        }

        @AfterClass
        @JvmStatic
        fun teardown() {
            Selenide.closeWebDriver()
        }
    }
}