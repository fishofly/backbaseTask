package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byCssSelector
import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step

class GlobalFeedPage {
    private val articlePage: SelenideElement = element(byXpath("//app-article-list"))

    @Step("Open first article")
    fun openFirstArticle() {
        articlePage.shouldBe(Condition.visible)
        articlePage.findAll(byCssSelector(".article-preview")).first().waitUntil(Condition.visible, 3000).click()
    }
}