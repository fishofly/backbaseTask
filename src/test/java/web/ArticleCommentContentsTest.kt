package web

import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import steps.rest.UserManagementSteps
import steps.web.CreatedArticleSteps
import steps.web.MainPageSteps
import utils.TestAccount
import kotlin.random.Random

@RunWith(Parameterized::class)
@Feature("Comment contents verification")
class ArticleCommentContentsTest(private val testComment: String) : BasicWebTest() {

    private val mainPageSteps: MainPageSteps = MainPageSteps() //to be nicely replaced by some spring config
    private val createdArticleSteps: CreatedArticleSteps = CreatedArticleSteps()
    private val userManagementSteps: UserManagementSteps = UserManagementSteps()

    private var testAccount: TestAccount? = null
    private var articleTitle: String = "Test article ${Random.nextInt(1000, 9999)}"

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("[!@#\$%^&*(),.?\":{}|<>]"),
            arrayOf("The standard Lorem Ipsum passage, used since the 1500s Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            arrayOf("喜遭険明会疑回促葉百木管育。Русский текст для проверки شر ليونيكود Können Stäbe gehen? Wer sieht die Stäbe vorübergehen?")
        )
    }

    @Before
    fun createTestAccount() {
        testAccount = userManagementSteps.createTestAccount()
    }

    @Test
    @Story("Validate article author can leave comments to own articles")
    fun checkCommentCreation() {
        mainPageSteps.openMainPage()
            .login(testAccount!!.username, testAccount!!.password)
            .createTestArticle(articleTitle)
        createdArticleSteps.addComment(testComment)
            .verifyCommentVisible(testComment)
    }

    @After
    fun cleanUp() {
        //add methods for user, articles removal
    }
}