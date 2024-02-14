import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class BaseTest {
    WebDriver driver ;
    public static Actions actions;
    public WebDriverWait wait;
    //public String url = "https://qa.koel.app/";
    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //maximize window
        driver.manage().window().maximize();
        //explicit wait don't forget to create an object in the beginning of the class WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navigateToUrl(baseURL);
    }


    public void navigateToUrl(String url){
        driver.get(url);

    }

    public void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        //explicit wait syntax;
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys("aida.taymaskhanova@testpro.io");
    }

    public void providePassword(String password){
        //WebElement passWord = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passWord = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        passWord.clear();
        passWord.sendKeys("Ozzikpozzik18");
    }

    public void clickSubmit(){
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();
    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }
}