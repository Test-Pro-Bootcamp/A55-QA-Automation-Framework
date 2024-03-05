import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    public String url = "https://qa.koel.app/";
    @Test
    public void loginEmptyEmailPassword() {
        // test for forking
//      Added ChromeOptions argument below to fix websocket error
        //navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
