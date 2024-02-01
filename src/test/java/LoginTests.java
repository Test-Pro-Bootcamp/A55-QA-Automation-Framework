import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        // here we just navigating to the page
        navigateToUrl();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }
    public void LoginInvalidEmail() {

    }
    public void LoginInvalidPassword() {

    }
}





