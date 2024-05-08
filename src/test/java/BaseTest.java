import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {


    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    @BeforeMethod
    @Parameters("baseUrl")
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        int timeSeconds = 5;
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(baseURL);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "";
        String authkey = "";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "110.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.158:4444";
        switch (browser) {
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                System.out.println("safari");
                return new SafariDriver(safariOptions);
            case "grid-safari":
                caps.setCapability("browserName", "Safari");
                System.out.println("grid-safari");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                System.out.println("grid-chrome");
                return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return new FirefoxDriver(optionsFirefox);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--remote-allow-origins=*");
                //optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                System.setProperty("webdriver.chrome.driver", "chromedriver-mac-arm64/chromedriver");
                return new ChromeDriver(optionsChrome);
        }
    }
    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }

}
