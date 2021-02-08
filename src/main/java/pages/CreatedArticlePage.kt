package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selectors.*
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import kotlin.test.Asserter

class CreatedArticlePage {
    private val banner: SelenideElement = element(".banner")
    private val commentField: SelenideElement = element(byAttribute("placeholder", "Write a comment..."))
    private val submitButton: SelenideElement = element(".btn-primary")
    private val commentsSection: SelenideElement = element(byXpath("//app-article-comment"))

    fun verifyArticleCreated(articleTitle: String): CreatedArticlePage {
        banner.shouldBe(Condition.visible).find(ByText(articleTitle)).shouldBe(Condition.visible)
        return this
    }

    fun verifyNoPostCommentButton(): CreatedArticlePage {
        submitButton.shouldNotBe(Condition.visible)
        return this
    }

    fun addComment(testComment: String): CreatedArticlePage {
        commentField.shouldBe(Condition.visible).sendKeys(testComment)
        submitButton.shouldBe(Condition.visible).click()
        return this
    }

    fun deleteComment(testComment: String): CreatedArticlePage {
        val commentBox = getCommentBoxes(testComment).first().shouldBe(Condition.visible)
        commentBox.parent().parent().find(byCssSelector(".mod-options")).shouldBe(Condition.visible).click()
        return this
    }

    fun verifyNoCommentsSection() {
        commentsSection.shouldNotBe(Condition.visible)
    }

    fun getCommentBoxes(testComment: String): List<SelenideElement> {
        return commentsSection.shouldBe(Condition.visible)
            .findAll(byCssSelector(".card-text")).filter { it.text == testComment }
    }
}