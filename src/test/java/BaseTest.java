import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.annotation.AnnotationList;
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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static final ThreadLocal <WebDriver> threadDriver = new ThreadLocal<>();//creating a thread driver for grid parallel execution
    public static WebDriver driver;//= null ;public static String url = null;
    public static Actions actions;// = null;
    public static WebDriverWait wait ;//= null;
    public String baseURL = "https://qa.koel.app/";
    //public Wait<WebDriver> fluentWait;

    //creating a method for threadDriver for selenium parallel testing
    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.firefoxdriver().setup();

    }
    @BeforeMethod
    @Parameters({"url"})
    public void launchBrowser(String url) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));//this line is added for selenium grid parallel testing
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//line for selenium grid parallel testing
        getDriver().manage().window().maximize();
        //replacing driver with getDriver() where there was driver
        //explicit wait don't forget to create an object in the beginning of the class WebDriverWait wait;
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        navigateToURL(url);
        actions = new Actions(getDriver());
    }
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.203:4444/";
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
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid=firefox" :
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid=chrome" :
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            // this line is for testing with cloud lambdaTest
            case "cloud":
                return LambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    public void navigateToURL( String url){
        getDriver().get(url);
    }
    @AfterMethod
    public void tearDown(){ //these lines are added for selenium grid parallel testing
        threadDriver.get().close();
        threadDriver.remove();
    }

    //this method is for executing test on the clod lambdatest
    public static WebDriver LambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("122.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "aika48120");
        ltOptions.put("accessKey", "lhbH6yUwYjtAXJ1tzarKCwSQR3Ih63fDj5AzP3dsrpZHKGLoXc");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

   // @AfterMethod
   // public void closeBrowser(){
       // driver.quit();
   // }
}