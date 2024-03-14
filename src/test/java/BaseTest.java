
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
    public static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getThreadLocal(){
        return THREAD_LOCAL.get();
    }

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
    void setupClass(){
       // WebDriverManager.chromedriver().setup();
       WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.safaridriver().setup();
    }


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void  setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // driver = new FirefoxDriver();
        //driver = new SafariDriver();
       // driver = pickBrowser(System.getProperty("browser"));
        //Implicit Wait
       // THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Explicit Wait
       // wait = new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        //FluentWait
       // fluentWait = new FluentWait<WebDriver>(getDriver())
              //  .withTimeout(Duration.ofSeconds(5))
              //  .pollingEvery(Duration.ofSeconds(1));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(baseURL);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + "and Driver reference is : " + getThreadLocal());
      //  actions = new Actions(getDriver());
       // navigateToPage(baseURL);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.155:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return  driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return  driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return  driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
                default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications","--remote-allow-origins=*","--incognito","--start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
                return driver = new ChromeDriver(chromeOptions);

        }

    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL ="https://hub.lambdatest.com/wd/hub";
        String username = "kaflimeerim" ;
        String accesskey = "QMc6U5vvIyCA65wxE32WhSBIKm24sBzrcQPfG2VXRO6Be42F3V";


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version","122.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG with Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin","git-testing");
        return new RemoteWebDriver(new URL("https://" + username + accesskey + hubURL),caps);
    }

   /* @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }*/
    @AfterMethod
    public void tearDown(){
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
    //Helper Method
    public void loginToKoel(){
        //WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
        //Thread.sleep(5000);

    }
    public void providePassword(String password){
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }
    public void navigateToPage(String url){
        getThreadLocal().get(url);

    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }
}