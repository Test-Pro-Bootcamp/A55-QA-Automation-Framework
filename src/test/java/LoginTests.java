
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTests extends BaseTest {
    @Test
    public void successfulLogin(){
        //Step1: Enter a valid registered email
        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        email.clear();
        email.sendKeys("nayana.rao.subramanya@testpro.io");

        //Step2: Enter a valid corresponding password
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Zqmvyk4hDaZ3vga");

        //Step3: Click on Login button
        WebElement loginButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        loginButton.click();

        //Step4: Assert/Check to see the avatar is displayed
        WebElement avatarIcon = driver.findElement(By.cssSelector("[class=\"avatar\"]"));
        boolean avatarPresent = avatarIcon.isDisplayed();
        Assert.assertTrue(avatarPresent,"The login is not successful");
    }

    @Test
    public void loginValidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.avatarFound().isDisplayed());
    }

    @Test
    public void invalidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nayanarao.subramanya@testpro.io");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
    }

    @Test
    public void validEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("abcd1234");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
    }

    @Test
    public void emptyEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
    }
}


