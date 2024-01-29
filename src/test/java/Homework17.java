import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void ValidCredentialsLogin(){
        //preconditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //declare web-driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Steps: 1 Open browser
        String url = "https://qa.koel.app/";
        driver.get(url);
        //Enter email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("aidataymaskhanova@testpro.io");
        //Send password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Ozzikpozzik18");
        WebElement LogInButton= driver.findElement(By.cssSelector("button[type='submit']"));
        LogInButton.click();
        WebElement SearchField = driver.findElement(By.cssSelector("input[type='search']"));
        SearchField.clear();
        SearchField.sendKeys("BornKing");
        SearchField.click();


        //Assertion (expected vs actual)
        //WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assert.assertTrue(avatar.isDisplayed());

        driver.quit();
    }


    }









