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
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public WebDriver driver;

    public WebDriverWait wait;

    public Wait<WebDriver> fluentWait;

    public Actions actions;

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }


    //public String url = "https://qa.koel.app/";

    //Data Providers Start
    /*@DataProvider(name="invalidLoginData")
    public Object[][] getDataFromDataProviders() {
            return new Object[][]{
        {"invalid@email.com", "invalidPassword"},
        {"demo@class.com", ""},
        {"", ""}
        {"invalid@email.com", "te$t$tudent"}
      };
    }
    //Data providers end
     */


    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.safaridriver().setup();

    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void launchBrowser(String baseURL) {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver = new SafariDriver();

        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //driver = pickBrowser(System.getProperty("browser"));
        //System.out.println();

        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Fluent Wait
        fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        actions = new Actions(getDriver());
        navigateToPage(baseURL);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps =  new DesiredCapabilities();
        String gridURL = "http://10.0.0.206:4444/";
        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browser", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browser", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browser", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case: "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }

    }

   /*
    public void closeBrowser() {
        driver.quit();
    }
    */


    public WebDriver lambdaTest () throws MalformedURLException {
        String hubUrl = "https://hub.lambdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();

       /*
        String hub = "@gub.lambdatest.com/wd/hub";
        String userName= "aziza.aminova";
        String authKey = "dk3J1X44X8jFHB17ABrj0stZwQ1OGhzM7Qe7UrjYdhydbJ3svC";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "122.0");
        capabilities.setCapability("resolution","2024x768");
        capabilities.setCapability("build", "TestNG with Java");
        capabilities.setCapability("name", BaseTest.class.getName());
        capabilities.setCapability("plagin", "java-testNG");
        */

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("122.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "aziza.aminova");
        ltOptions.put("accessKey", "dk3J1X44X8jFHB17ABrj0stZwQ1OGhzM7Qe7UrjYdhydbJ3svC");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        //return new RemoteWebDriver(new URL("https://"+userName+":"authKey + hub), capabilities);
        return new RemoteWebDriver(new URL(hubUrl), capabilities);
    }

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }

    //Helper Methods

    public void loginToKoel() {
        //WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
         WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("button[type='submit']")));
        loginBtn.click();
        //Thread.sleep(5000);
    }

    public void providePassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage(String url) {
        getDriver().get(url);
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

}