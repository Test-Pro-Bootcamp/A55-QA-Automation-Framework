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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public WebDriver driver = null;

    public WebDriverWait wait;

    public Actions actions;

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

   // public String url = "http://qa.koel.app/";

    //Data Providers Start
 /* @DataProvider(name="invalidLoginData")
    public Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"invalid@email.com","invalidPassword"},
                {"ionut.burtoiu@testpro.io",""},
                {"",""},
                {"invalid@email.com","Luca@20222"}
        };
    }*/



    //Data Providers Ends

    @BeforeSuite
    static void setupClass() {
      // WebDriverManager.chromedriver().setup();
       //WebDriverManager.firefoxdriver().setup();
      // WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void lunchBrowser(String baseURL) throws MalformedURLException {
        // Added ChromeOptions argument below to fix websocket error
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

       //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver = pickBrowser(System.getProperty("browser"));
        System.out.println();
        //Implicit Wait
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        //wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));

        //driver.manage().window().maximize();
        getDriver().manage().window().maximize();
       // actions = new Actions(driver);
        actions = new Actions(getDriver());
        navigateToPage(baseURL);

    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL ="http://192.168.1.158:4444/";
       switch (browser){
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               return driver = new FirefoxDriver();
           case "MicrosoftEdge":
               WebDriverManager.edgedriver().setup();
               EdgeOptions  edgeOptions = new EdgeOptions();
               edgeOptions.addArguments("--remote-allow-origins=*");
               return driver = new EdgeDriver(edgeOptions);
           case "Safari":
               WebDriverManager.safaridriver().setup();
               return driver = new SafariDriver();
            case "grid-ege":
               caps.setCapability("browserName","MicrosoftEdge");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
          case "grid-firefox":
               caps.setCapability("browserName","firefox");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
           case "grid-chrome":
               caps.setCapability("browserName","chrome");
               return driver =  new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
           case "grid-safari":
               caps.setCapability("browserName","safari");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
           case "cloud":
               return lambdaTest();
           default:
               WebDriverManager.chromedriver().setup();
               ChromeOptions chromeOptions = new ChromeOptions();
               chromeOptions.addArguments("--remote-allow-origins=*");
               return driver = new ChromeDriver(chromeOptions);

       }


    }
public WebDriver lambdaTest() throws MalformedURLException {
    String hubUrl = "https://hub.lambdatest.com/wd/hub";


    DesiredCapabilities capabilities = new DesiredCapabilities();
    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setPlatformName("Windows 10");
    browserOptions.setBrowserVersion("123.0");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    ltOptions.put("username", "burtoiuionut89");
    ltOptions.put("accessKey", "2SM3oa4HOewKNvpqpVge9k0PEsyoNDklrhaFeR7Fd1URaZRich");
    ltOptions.put("project", "Untitled");
    ltOptions.put("selenium_version", "4.0.0");
    ltOptions.put("w3c", true);
    browserOptions.setCapability("LT:Options", ltOptions);
  return new RemoteWebDriver(new URL(hubUrl),capabilities);
}
    /*@AfterMethod
    public void closeBrowser(){
        driver.quit();

    }*/
    @AfterMethod

    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void clickSubmit() {
       // WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    public void providePassword(String password) {
      //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
      passwordField.clear();
      passwordField.sendKeys("Luca@20222");
    }

    public void provideEmail(String email) {
      // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
       emailField.click();
       emailField.sendKeys(email);
    }

    public void navigateToPage(String url) {
        //driver.get(url);
        getDriver().get(url);
    }

        public void chooseAllSongsList() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='songs'] "))).click();
        }


    }
