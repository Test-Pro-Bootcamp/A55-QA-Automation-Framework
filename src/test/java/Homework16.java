import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void logInValidEmailPassword(){
        //Pre-condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Declaration
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Steps
        //Steps 1: Open Browser and navigate to Koel app.
        String url = "https://qa.koel.app/";
        driver.get(url);
        //Step 2: Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        //Step 3: Enter Password
        WebElement  passwordField = driver.findElement(By.cssSelector("input{Type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        //Step 4: Click on Login buttom
        WebElement loginBtn =driver.findElement(By.cssSelector("button[type='submit']"));
        //Assertion (expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }







}
