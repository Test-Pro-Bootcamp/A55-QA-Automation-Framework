import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("baseUrl")
    public void launchBrowser(String baseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //System.setProperty("webdriver.chrome.driver", "chromedriver-mac-arm64/chromedriver");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
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

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
