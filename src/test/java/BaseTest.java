import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
   // @BeforeSuite
    public WebDriver driver;

    public Actions actions;

    @BeforeSuite
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //Helper Methods

    public void loginToKoel() {
        WebElement loginBtn =  driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        //Thread.sleep(5000);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }
}