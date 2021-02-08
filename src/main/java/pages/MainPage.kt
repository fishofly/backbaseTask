package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement

class MainPage {
    private val loginButton: SelenideElement = element(byText("Sign in"))
    private val newArticleButton: SelenideElement = element(byText("New Post"))
    private val globalFeedButton: SelenideElement = element(byText("Global Feed"))

    fun openNewArticlePage(): NewArticlePage {
        newArticleButton.shouldBe(Condition.visible).click()
        return NewArticlePage()
    }

    fun openGlobalFeed(): GlobalFeedPage {
        globalFeedButton.shouldBe(Condition.visible).click()
        return GlobalFeedPage()
    }
}