import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.Callable;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //STep:1 Open Browser and navigate to Koel app;
        navigateToPage();
        //Step:2 Enter email
        provideEmail("kaflimeerim@gmail.com");
        //Step:3 Enter password
        providePassword("te$t$tudent");
        //Step:4 Click on login button
        loginToKoel();
        //Thread.sleep(2000);
        //Step:5 Assertion (expected vs actual)
        WebElement avatorIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatorIcon.isDisplayed());
       // driver.quit();

    }
    @Test
    public void  loginInvalidEmailValidPassword(){
        navigateToPage();

        // Step:1 Enter email
        provideEmail("invalidEmail@gmail.com");
        // Step:2 Enter password
        providePassword("te$t$tudent");
        //Step:3 Click on login btn
        loginToKoel();
        //clickSubmit

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //driver.quit();

    }
    @Test
    public void loginValidEmailEmptyPassword(){
        navigateToPage();
        provideEmail("kaflimeerim@gmail.com");
        providePassword("invalidPassword");
        loginToKoel();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
       // driver.quit();

    }


}
