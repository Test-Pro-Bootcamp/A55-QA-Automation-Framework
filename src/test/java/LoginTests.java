import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

import java.time.Duration;

//login with valid email using object method
public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPasswordTest() {
        //creating objects
        LogInPage loginPage = new LogInPage(driver);
        HomePage homePage = new HomePage(driver);
        LogInPage.provideEmail("aida.taymaskhanova@testpro.io");
        LogInPage.providePassword("Ozzikpozzik18");
        LogInPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

//      Added ChromeOptions argument below to fix websocket error
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //String url = "https://qa.koel.app/";
        //driver.get(url);
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        //driver.quit();
    }
}
