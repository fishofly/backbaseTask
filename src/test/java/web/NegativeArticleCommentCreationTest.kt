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

@Feature("Creating comments - negative tests")
class NegativeArticleCommentCreationTest() : BasicWebTest() {

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
    @Story("Validate Post Comment button is not visible until text is entered")
    fun checkEmptyCommentCreation() {
        mainPageSteps.openMainPage()
            .login(testAccount!!.username, testAccount!!.password)
            .createTestArticle(articleTitle)
        createdArticleSteps.verifyNoPostCommentButton()
    }

    @After
    fun cleanUp() {
        //add methods for user, articles removal
    }
}