import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;//= null ;
    public static String url = null;
    public static Actions actions;// = null;
    public static WebDriverWait wait ;//= null;
    public String baseURL = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"url"})
    public void launchBrowser(String url) {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //implicit wait
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //maximize window
        driver.manage().window().maximize();
        //explicit wait don't forget to create an object in the beginning of the class WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        navigateToURL(url);
        actions = new Actions(driver);
    }

    public static WebDriver pickBrowser(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "Microsoft Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }


    public void navigateToURL( String url){
        driver.get(url);

    }

   /* @BeforeMethod
    public static ChromeDriver getChromeDriver() {
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeOptions chromeOptions = new ChromeOptions();
        return new ChromeDriver(chromeOptions);
    }*/






    //public void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        //explicit wait syntax;
       // WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        //emailField.clear();
       // emailField.sendKeys("aida.taymaskhanova@testpro.io");
    //}

   // public void providePassword(String password){
        //WebElement passWord = driver.findElement(By.cssSelector("input[type='password']"));
       // WebElement passWord = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
       // passWord.clear();
       // passWord.sendKeys("Ozzikpozzik18");
   // }

    //public void clickSubmit(){
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
       // WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
       // submit.click();
    //}

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}