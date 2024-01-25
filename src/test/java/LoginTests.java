
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
    public void successfulLogin(){
        //Preconditions
//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); //Allows the browser to automate the process and gives the required permissions

        //Declarations
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//5 seconds or 10 seconds?

        //Step1: Open the webpage in Chrome browser
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Step2: Enter a valid registered email
        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        email.clear();
        email.sendKeys("nayana.rao.subramanya@testpro.io");

        //Step3: Enter a valid corresponding password
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Zqmvyk4hDaZ3vga");

        //Step4: Click on Login button
        WebElement loginButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        loginButton.click();

        //Step5: Assert/Check to see the avatar is displayed
        WebElement avatarIcon = driver.findElement(By.cssSelector("[class=\"avatar\"]"));
        boolean avatarPresent = avatarIcon.isDisplayed();
        Assert.assertTrue(avatarPresent,"The login is not successful");

        //Close the browser window
        driver.quit();
    }
}
