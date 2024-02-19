import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.HashMap;

abstract class BaseTest {
    public WebDriver driver;

    protected void initChromeDriver() throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.178.50:4444";

        switch (browser){
            case "lambda-chrome":
                String hubUrl = "https://hub.lambdatest.com/wd/hub";
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("macOS Ventura");
                browserOptions.setBrowserVersion("121.0");
                HashMap<String, Object> ltOptions = new HashMap<String, Object>();
                ltOptions.put("username", "ana.nicora");
                ltOptions.put("accessKey", "3leTzgQsqFnRXwjnOxTgYKGkttlPk9abjWNwQnOHym6wQBrutf");
                ltOptions.put("resolution", "1920x1080");
                ltOptions.put("project", "Untitled");
                ltOptions.put("selenium_version", "4.13.0");
                ltOptions.put("driver_version", "121.0");
                ltOptions.put("w3c", true);
                ltOptions.put("plugin", "java-testNG");
                browserOptions.setCapability("LT:Options", ltOptions);
                return driver = new RemoteWebDriver(URI.create(hubUrl).toURL(), browserOptions);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return driver = new FirefoxDriver(firefoxOptions);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions EdgOps = new EdgeOptions();
                EdgOps.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(EdgOps);


            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
        }

    }

    protected void quitChromeDriver() {
        driver.quit();
    }
}