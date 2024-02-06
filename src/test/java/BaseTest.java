import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        launchWebsite(BaseURL);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void launchWebsite(String baseURL) {
        driver.get(baseURL);
    }
    public void enterEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"email\"]")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"password\"]")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void loginButton(){
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type=\"submit\"]")));
        loginButton.click();
    }
    public void editButtonClick() {
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-testid,\"playlist-context-menu-edit\")]")));
        editButton.click();
    }
}