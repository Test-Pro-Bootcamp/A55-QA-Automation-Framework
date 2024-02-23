import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

//login with valid email using POM
public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() {
        //creating objects
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LogInPage.provideEmail("aida.taymaskhanova@testpro.io");
        LogInPage.providePassword("Ozzikpozzik18");
        LogInPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPasswordTest() {
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LogInPage.provideEmail("taymaskhanova@testpro.io");
        LogInPage.providePassword("Ozzikpozzik18");
        LogInPage.clickSubmit();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailAndPasswordTest(){
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LogInPage.provideEmail("");
        LogInPage.providePassword("");
        LogInPage.clickSubmit();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginEmptyEmailValidPasswordTest() {
        LogInPage loginPage = new LogInPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LogInPage.provideEmail("taymaskhanova@testpro.io");
        LogInPage.providePassword("Ozzikpozzik18");
        LogInPage.clickSubmit();
        //Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}

