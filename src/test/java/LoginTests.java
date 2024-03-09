import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    public String url = "https://qa.koel.app/";
    @Test
    public void loginEmptyEmailPassword() {
        //navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
