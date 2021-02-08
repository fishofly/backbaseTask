package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class LoginPage {
    private val usernameInput: SelenideElement = element(byAttribute("placeholder", "Username"))
    private val passwordInput: SelenideElement = element(byAttribute("placeholder", "Password"))
    private val submitButton: SelenideElement = element(".btn-primary")
    private val navigationBar: SelenideElement = element(".navbar-nav")

    fun performLogin(username: String, password: String): LoginPage {
        usernameInput.shouldBe(Condition.visible).setValue(username)
        passwordInput.shouldBe(Condition.visible).setValue(password)
        submitButton.shouldBe(Condition.visible).click()
        return this
    }

    fun verifyLoginSuccessful(username: String) {
        navigationBar.shouldBe(Condition.visible).find(By.partialLinkText(username.substringBefore("@")))
    }
}