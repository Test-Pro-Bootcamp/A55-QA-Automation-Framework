import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;


public class LoginTests extends BaseTest {

    private LoginPage loginPage;

    private HomePage homePage;

    @BeforeSuite
    void beforeSuite() throws MalformedURLException {
        initChromeDriver();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterSuite
    void afterSuite() {
        quitChromeDriver();
    }

    //Login with Valid email Test using the Page Object Model
    @Test
    @Parameters({"BaseURL", "Email", "Password"})
    public void loginValidEmailValidPasswordTest(String baseURL, String email, String password) {
        loginPage.login(baseURL, email, password);

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}



