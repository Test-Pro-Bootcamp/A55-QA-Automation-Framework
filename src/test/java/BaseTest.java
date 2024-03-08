import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;

    public Actions actions;


    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String baseURL) throws MalformedURLException, URISyntaxException {
       threadDriver.set(pickBrowser(System.getProperty("browser")));
        threadDriver.get().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().navigate().to(baseURL);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        //System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getDriver());
    }
    //This is the method for parallel execution


    @BeforeSuite
    public static void setupClass() {

        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException, URISyntaxException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.104:4444";
        switch(browser){
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
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
/*
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBasic(String baseURL) throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--remote-allow-origins=*"); //Allows the browser to automate the process and gives the required permissions
        //driver = new ChromeDriver(options);
        //driver = new EdgeDriver();
        //driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        System.out.println();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//5 seconds or 10 seconds?
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    */
   /* @BeforeMethod
    public void setupPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }*/

    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();// Parallel execution
        threadDriver.remove();
        //driver.quit();
    }

    public WebDriver lambdaTest() throws MalformedURLException, URISyntaxException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("121.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "nayana.rao.subramanya");
        ltOptions.put("accessKey", "jpX7iz5JkRTDxUMAICAibQPdZDTaxNpchbGfA7epSVtAfVYy9c");
        ltOptions.put("build", "Selenium Grid Cloud");
        ltOptions.put("project", "Selenium Grid Cloud-25");
        ltOptions.put("selenium_version", "4.17.0");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "git-testng");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URI(hubURL).toURL(),browserOptions);
    }

    @DataProvider(name="themeData")
    public static Object[][] NewTheme(){

        return new Object[][] {

                {"Violet", "//ul/li[2]/div"},
                {"Classic", "//ul/li[1]/div"},
                {"Oak", "//ul/li[3]/div"},
                {"Slate", "//section[@id='profileWrapper']//ul[@class='themes']/li[4]/div[@class='theme']/div"}
                };
    }
}