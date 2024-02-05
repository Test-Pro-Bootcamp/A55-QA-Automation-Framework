import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test (dataProvider = "InvalidLoginDetails")
    public void invalidLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        loginButton();
        WebElement koelLoginPageLogo = driver.findElement(By.cssSelector("[class=\"logo\"]"));
        Assert.assertTrue(koelLoginPageLogo.isDisplayed());
    }

    @Test
    public void validLogin(){
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        WebElement avatarIcon = driver.findElement(By.cssSelector("[class=\"avatar\"]"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
