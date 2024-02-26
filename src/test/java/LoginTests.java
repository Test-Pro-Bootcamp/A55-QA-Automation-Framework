import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest{
    @Test
    public void loginValidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("taqimed99@gmail.com")
                .providePassword("Med-20115-010499@")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("")
                .providePassword("")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
    @Test
    public void loginEmptyEmailValidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("")
                .providePassword("Med-20115-010499@")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
    @Test
    public void loginValidEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("taqimed99@gmail.com")
                .providePassword("")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
    @Test
    public void loginInvalidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("test@gmail.com")
                .providePassword("12345@")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }

}
