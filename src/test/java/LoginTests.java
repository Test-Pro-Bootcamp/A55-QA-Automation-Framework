import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        //navigateToPage();
        //gradle clickAssert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() {
        // navigateToPage();
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();


        ///WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();

    }

    @Test(dataProvider = "invalidLoginData")
    public void loginWithNegativeData(String email, String password) {
        //navigateToPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();

        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }

   /* @Test
    public void loginInvalidEmailValidPassword() {
        //navigateToPage();
        provideEmail("invalid@class.com");
        providePassword("te$tStudent");
        clickSubmit();


        // WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }*/

   /* @Test
    public void loginValidEmailEmptyPassword() {
        //navigateToPage();
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("");
        clickSubmit();

        //Assertions (Expected vs actual)
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
        driver.quit();


    }*/

    //Login with valid email Test using the Page Object Model
    @Test
    public void loginValidEmailValidPasswordTest() {
        //LoginPage loginPage = new LoginPage(driver);
        //HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());


        loginPage.provideEmail("ionut.burtoiu@testpro.io");
        loginPage.providePassword("Luca@20222");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInValidEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());


        loginPage.provideEmail("ionutburtoiu@testpro.io");
        loginPage.providePassword("Luca@20222");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());


        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}

