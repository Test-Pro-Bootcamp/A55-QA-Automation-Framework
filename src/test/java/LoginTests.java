import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // version error fix
        System.setProperty("webdriver.chrome.driver", "chromedriver-mac-arm64/chromedriver");
        //declaration
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // step 1 browse to correct website
        String url = "https://qa.koel.app/";
        driver.get(url);

        // step 2 enter email

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
