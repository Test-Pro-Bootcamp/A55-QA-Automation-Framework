import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

//login with valid email using POM
public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() throws InterruptedException {
        //creating objects
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(2000);
        LogInPage.provideEmail("aida.taymaskhanova@testpro.io");
        Thread.sleep(2000);
        LogInPage.providePassword("Ozzikpozzik18");
        Thread.sleep(2000);
        LogInPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        Thread.sleep(2000);
    }

    @Test
    public void loginInvalidEmailValidPasswordTest() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(2000);
        LogInPage.provideEmail("taymaskhanova@testpro.io");
        Thread.sleep(2000);
        LogInPage.providePassword("Ozzikpozzik18");
        Thread.sleep(2000);
        LogInPage.clickSubmit();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailAndPasswordTest() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(2000);
        LogInPage.provideEmail("");
        Thread.sleep(2000);
        LogInPage.providePassword("");
        Thread.sleep(2000);
        LogInPage.clickSubmit();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailValidPasswordTest() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Thread.sleep(2000);
        LogInPage.provideEmail("taymaskhanova@testpro.io");
        Thread.sleep(2000);
        LogInPage.providePassword("Ozzikpozzik18");
        Thread.sleep(2000);
        LogInPage.clickSubmit();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }






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

