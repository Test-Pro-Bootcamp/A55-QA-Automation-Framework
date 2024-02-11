import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends BaseTest {

    //Login with Valid email Test using the Page Object Model
    @Test
    @Parameters({"BaseURL", "Email", "Password"})
    public void loginValidEmailValidPasswordTest(String baseURL, String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login(baseURL, email, password);

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }


}



