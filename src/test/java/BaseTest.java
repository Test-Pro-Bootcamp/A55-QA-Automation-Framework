import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        return threadLocal.get();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(@Optional String BaseUrl) throws MalformedURLException {
        threadLocal.set(pickBrowser(System.getProperty("browser")));
        threadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        threadLocal.get().manage().window().maximize();
        threadLocal.get().manage().deleteAllCookies();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        actions = new Actions(getDriver());
        getDriver().get(BaseUrl);
    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.1.150:4444";
        switch ("browser") {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions EdgOps = new EdgeOptions();
                EdgOps.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(EdgOps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new FirefoxDriver();
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(ops);


        }
    }

    private WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("121.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "taqimed99");
        ltOptions.put("accessKey", "4pgzKgaVZzOS73tKVr8OmRqfKbWP14B21ArvrmZlll7yLKrab3");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    @AfterMethod
    public void closeBrowser(){
        threadLocal.get().close();
        threadLocal.remove();
  }
}
