package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byAttribute
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step

class NewArticlePage {
    private val articleTitleInput: SelenideElement = element(byAttribute("placeholder", "Article Title"))
    private val articleTextInput: SelenideElement =
        element(byAttribute("placeholder", "Write your article (in markdown)"))
    private val submitButton: SelenideElement = element(byAttribute("type", "button"))

    @Step("Create new article with title {articleTitle}")
    fun createNewArticle(articleTitle: String): CreatedArticlePage {
        articleTitleInput.shouldBe(Condition.visible).setValue(articleTitle)
        articleTextInput.shouldBe(Condition.visible).setValue("Sample text for article $articleTitle")
        submitButton.shouldBe(Condition.visible).click()
        return CreatedArticlePage()
    }
}