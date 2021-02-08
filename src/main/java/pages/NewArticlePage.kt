package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors.byAttribute
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement

class NewArticlePage {
    private val articleTitleInput: SelenideElement = element(byAttribute("placeholder", "Article Title"))
    private val articleTextInput: SelenideElement =
        element(byAttribute("placeholder", "Write your article (in markdown)"))
    private val submitButton: SelenideElement = element(".btn-primary")

    fun createNewArticle(articleTitle: String): CreatedArticlePage {
        articleTitleInput.shouldBe(Condition.visible).setValue(articleTitle)
        articleTextInput.shouldBe(Condition.visible).setValue("Sample text for article $articleTitle")
        submitButton.shouldBe(Condition.visible).click()
        return CreatedArticlePage()
    }
}