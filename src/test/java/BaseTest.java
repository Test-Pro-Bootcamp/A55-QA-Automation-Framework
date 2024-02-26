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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    public WebDriver driver ;
    public WebDriverWait wait;
    public static Actions actions;

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    public String url = "https://qa.koel.app/";
    @BeforeSuite
    void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // implicit wait
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //explicit wait
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        navigateToPage(baseURL);
        actions =new Actions(getDriver());
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.8:4444/";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                //WebDriverManager.firefoxdriver().setup();
                //return driver = new FirefoxDriver();
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver= new ChromeDriver(chromeOptions);

        }
    }
    public WebDriver lambdaTest() throws MalformedURLException{
        String hub = "@hub.lambdatest.com/wd/hub";
        String username ="nicolai.luta";
        String accessKey = "1VTOWxpF8DX3HRNkA5DnCb0aFzJz4264LZG9Zz2RxX02cv3CeG";

        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("121.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "nicolai.luta");
        ltOptions.put("accessKey", "1VTOWxpF8DX3HRNkA5DnCb0aFzJz4264LZG9Zz2RxX02cv3CeG");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL( "https://" + username + ":" + accessKey + hub), caps);
    }
        @AfterMethod

        public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
        }

        public void navigateToPage (String url){
            getDriver().get(url);
        }

        public void provideEmail (String email){
            //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
            emailField.clear();
            emailField.sendKeys(email);
        }

        public void providePassword (String password){
            //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
            passwordField.clear();
            passwordField.sendKeys(password);
        }

        public void clickSubmit () {
            //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
            submit.click();
        }

    }
