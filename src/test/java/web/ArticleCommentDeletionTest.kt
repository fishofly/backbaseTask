package web

import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.After
import org.junit.Before
import org.junit.Test
import steps.rest.UserManagementSteps
import steps.web.CreatedArticleSteps
import steps.web.MainPageSteps
import utils.TestAccount
import kotlin.random.Random

@Feature("Deleting comments")
class ArticleCommentDeletionTest : BasicWebTest() {

    private val mainPageSteps: MainPageSteps = MainPageSteps() //to be nicely replaced by some spring config
    private val createdArticleSteps: CreatedArticleSteps = CreatedArticleSteps()
    private val userManagementSteps: UserManagementSteps = UserManagementSteps()

    private var testAccount: TestAccount? = null
    private var articleTitle: String = "Test article ${Random.nextInt(1000, 9999)}"
    private var testComment: String = "Test comment for $articleTitle"

    @Before
    fun createTestAccount() {
        testAccount = userManagementSteps.createTestAccount()
    }

    @Test
    @Story("Validate user can delete own comments")
    fun checkCommentDeleting() {
        mainPageSteps.openMainPage()
            .login(testAccount!!.username, testAccount!!.password)
            .createTestArticle(articleTitle)

        createdArticleSteps.addComment(testComment)
            .verifyCommentVisible(testComment)
            .deleteComment(testComment)
            .verifyCommentNotShown(testComment)
    }

    @After
    fun cleanUp() {
        //add methods for user, articles removal
    }
}