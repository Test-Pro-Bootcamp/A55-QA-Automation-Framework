import com.google.common.cache.AbstractCache;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBasic(String baseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); //Allows the browser to automate the process and gives the required permissions
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//5 seconds or 10 seconds?
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
    }
   /* @BeforeMethod
    public void setupPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }*/

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void enterEmail(){
        WebElement emailField = driver.findElement(By.cssSelector("[type=\"email\"]"));
        emailField.sendKeys("nayana.rao.subramanya@testpro.io");
    }

    public void enterPassword(){
        WebElement passwordField = driver.findElement(By.cssSelector("[type=\"password\"]"));
        passwordField.sendKeys("Zqmvyk4hDaZ3vga");
    }

    public void loginButton() throws InterruptedException {
        WebElement logInButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        logInButton.click();
        Thread.sleep(1000);
        WebElement avatardisplayed = driver.findElement(By.cssSelector("[class=\"avatar\"]"));
        Assert.assertTrue(avatardisplayed.isDisplayed(), "Login Unsuccessful");
    }

    public void searchFieldAccess(){
        WebElement searchField = driver.findElement(By.cssSelector("[type=\"search\"]"));
        searchField.clear();
        searchField.sendKeys("Tunnel of Lights (ID 1689)");
    }

    public void searchFieldAccess1(){
        WebElement searchField = driver.findElement(By.cssSelector("[type=\"search\"]"));
        searchField.clear();
        searchField.sendKeys("Dee");
    }

    public void goHome(){
        WebElement homePage = driver.findElement(By.cssSelector("[href=\"#!/home\"]"));
        homePage.click();
    }
    public void launchWebsite(String baseURL){
        driver.get(baseURL);
    }
}