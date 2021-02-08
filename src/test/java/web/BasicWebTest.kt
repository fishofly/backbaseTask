package web

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.junit.TextReport
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule

open class BasicWebTest {

    @Rule
    public lateinit var report: TextReport

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