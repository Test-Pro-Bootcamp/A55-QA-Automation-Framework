import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //Negative test cases for login page
    @Test
    public void loginInvalidEmailPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo31@testpro.io");
        loginPage.providePassword("15sdf56D");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.isNotVisibleAvatarIcon());
    }
    @Test
    public void loginValidEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("nicolai.luta@testpro.io");
        loginPage.providePassword("InvalidPass12");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.isNotVisibleAvatarIcon());

    }
    @Test
    public void loginInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("abd.12rt@testpro.io");
        loginPage.providePassword("tAPO0uuR");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.isNotVisibleAvatarIcon());
    }
    @Test
    public void emptyEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.isNotVisibleAvatarIcon());
    }

}

