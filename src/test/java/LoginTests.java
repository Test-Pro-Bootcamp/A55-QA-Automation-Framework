import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
 /*   @Test
    public void loginEmptyEmailPassword() {
        //navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();
    }

  */

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Step 1: Open browser and navigate to Koel app.
        //navigateToPage();
        //Step 2: Enter email
        provideEmail("demo@class.com");
        //Step3 : Enter Password
        providePassword("te$t$tudent");
        //Step 4: Click Login button
        logintoKoel();
        //Assertion (expected vs. actual)
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Explicit Wait
        //WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        WebElement avatarIcon = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestData.class)
    public void loginWithNegativeData(String email, String password) {
        //Step 2: Enter email
        provideEmail(email);
        //Step3 : Enter Password
        providePassword(password);
        //Step 4: Click Login button
        logintoKoel();
        //Assertion (expected vs. actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        //Quit Browser
        //driver.quit();
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    //Login with Valid email Test using the PAGE OBJECT MODEL (POM)
    @Test
    public void loginValidEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        Thread.sleep(2000);
        loginPage.providePassword("te$t$tudent");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    } catch(Exception e) {
        System.out.println("Something went wrong" + e);
        Assert.fail();
    }

    @Test
    public void loginInValidEmailValidPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }


    @Test
    public void loginInvalidEmailValidPassword() {
        //Step 2: Enter email
        provideEmail("invalid@class.com");
        //Step3 : Enter Password
        providePassword("te$t$tudent");
        //Step 4: Click Login button
        logintoKoel();
        //Assertion (expected vs. actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        //Quit Browser
        Assert.assertTrue(avatarIcon.isDisplayed());
    }


    @Test
    public void loginValidEmailEmptyPassword() {
        //Step 2: Enter email
        provideEmail("demo@class.com");
        //Step3 : Enter Password
        providePassword("");
        //Step 4: Click Login button
        logintoKoel();
        //Assertion (expected vs. actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

}