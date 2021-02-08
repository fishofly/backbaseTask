package steps.web

import org.junit.Assert
import pages.CreatedArticlePage

class CreatedArticleSteps {
    private val createdArticlePage: CreatedArticlePage = CreatedArticlePage()

    fun addComment(testComment: String): CreatedArticleSteps {
        createdArticlePage.addComment(testComment)
        return this
    }

    fun verifyNoPostCommentButton(): CreatedArticleSteps {
        createdArticlePage.verifyNoPostCommentButton()
        return this
    }

    fun verifyCommentVisible(testComment: String): CreatedArticleSteps {
        val shownComments = createdArticlePage.getCommentBoxes(testComment)
        Assert.assertEquals("Comment $testComment should be visible", 1, shownComments.size)
        return this
    }

    fun deleteComment(testComment: String): CreatedArticleSteps {
        createdArticlePage.deleteComment(testComment)
        return this
    }

    fun verifyCommentNotShown(testComment: String): CreatedArticleSteps {
        createdArticlePage.verifyNoCommentsSection()
        return this
    }
}