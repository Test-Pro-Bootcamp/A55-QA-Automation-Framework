import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void browserSetup(String baseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        launchWebsite(baseUrl);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void launchWebsite(String baseUrl) {
        driver.get(baseUrl);
    }
    public void enterEmail(String provideEmail){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"email\"]")));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(provideEmail);
    }
    public void enterPassword(String passwordProvided){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"password\"]")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(passwordProvided);
    }
    public void loginButton(){
       // WebElement login = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type=\"submit\"]"))).click();
    }
    @DataProvider(name="InvalidLoginDetails")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"nayana.rao.subramanya@testpro.io","abcd123"},
                {"demo@gmail.com","Zqmvyk4hDaZ3vga"},
                {"student@testpro.com","abcd1234"},
                {"",""}
        };
    }
}