package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step

class MainPage {
    private val newArticleButton: SelenideElement = element(byText("New Post"))
    private val globalFeedButton: SelenideElement = element(byText("Global Feed"))

    @Step("Open new article page")
    fun openNewArticlePage(): NewArticlePage {
        newArticleButton.shouldBe(Condition.visible).click()
        return NewArticlePage()
    }

    @Step("Open global feed")
    fun openGlobalFeed(): GlobalFeedPage {
        globalFeedButton.shouldBe(Condition.visible).click()
        return GlobalFeedPage()
    }
}