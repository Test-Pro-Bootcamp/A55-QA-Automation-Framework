import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.request.body.multipart.StringPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    //public String url = "https://qa.koel.app/";

    //DataProvider
   /* @DataProvider(name= "invalidLoginData")
    public Object [][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalid@gmail.com", "invalidPassword"},
                {"kaflimeerim@gmail.com", " "},
                {" ", " "},
                {"invalid@gmail", "te$t$tudent"}
        };
    }
    */

    @BeforeSuite

    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void  launchBrowser(String baseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage(baseURL);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    //Helper Method
    public void loginToKoel(){
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        //Thread.sleep(5000);

    }
    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }
    public void navigateToPage(String url){
        driver.get(url);
    }
}