package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byCssSelector
import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement

class GlobalFeedPage {
    private val articlePage: SelenideElement = element(byXpath("//app-article-list"))

    fun openFirstArticle() {
        articlePage.shouldBe(Condition.visible)
        articlePage.findAll(byCssSelector(".article-preview")).first().waitUntil(Condition.visible, 3000).click()
    }
}