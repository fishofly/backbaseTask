package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byName
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement

class MainPage {
    private val search: SelenideElement = element(byName("q"))

    fun checkSearchVisible(): MainPage {
        search.shouldBe(Condition.visible)
        return this
    }
}