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

@Feature("Creating comments")
class ArticleCommentCreationTest() : BasicWebTest() {

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
    @Story("Validate article author can leave comments to own articles")
    fun checkCommentCreationByArticleCreator() {
        mainPageSteps.openMainPage()
            .login(testAccount!!.username, testAccount!!.password)
            .createTestArticle(articleTitle)
        createdArticleSteps.addComment(testComment)
            .verifyCommentVisible(testComment)
    }

    @Test
    @Story("Validate authorized user can leave comments to other user articles")
    fun checkCommentCreationByAuthorizedStranger() {
        mainPageSteps.openMainPage()
            .login(testAccount!!.username, testAccount!!.password)
            .openFirstArticle()
        //since it's a new user it is safe to open other random articles,
        //better would be to do via search not to hamper other tests, but there is no search of a particular article...

        createdArticleSteps.addComment(testComment)
            .verifyCommentVisible(testComment)
    }

    @Test
    @Story("Validate unauthorized user cannot leave comments to articles")
    fun checkCommentCreationByUnauthorizedStranger() {
        mainPageSteps.openMainPage()
            .openFirstArticle()
        //since it's a new user it is safe to open other random articles,
        //better would be to do via search, but there is no search of a particular article...

        createdArticleSteps.verifyNoPostCommentButton()
    }

    @After
    fun cleanUp() {
        //add methods for user, articles removal
    }
}