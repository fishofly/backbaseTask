package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byAttribute
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.Keys

class LoginPage {
    private val usernameInput: SelenideElement = element(byAttribute("placeholder", "Username"))
    private val passwordInput: SelenideElement = element(byAttribute("placeholder", "Password"))
    private val submitButton: SelenideElement = element(".auth-page").find(byAttribute("type", "submit"))
    private val navigationBar: SelenideElement = element(".navbar-nav")

    @Step("Perform login for {username}")
    fun performLogin(username: String, password: String): LoginPage {
        usernameInput.shouldBe(Condition.visible).setValue(username)
        passwordInput.shouldBe(Condition.visible).setValue(password)
        submitButton.shouldBe(Condition.visible).sendKeys(Keys.SHIFT)
        submitButton.click()
        return this
    }

    @Step("Verifying login for {username} is successful")
    fun verifyLoginSuccessful(username: String) {
        navigationBar.shouldBe(Condition.visible).find(By.partialLinkText(username.substringBefore("@"))).shouldBe(Condition.visible)
    }
}