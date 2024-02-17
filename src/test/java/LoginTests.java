import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("")
                .providePassword("te$t$tudent")
                .clickBtn();

        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }

    @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("taqimed99@gmail.com")
                .providePassword("Med-20115-010499@")
                .clickBtn();

        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }

    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());


        loginPage.provideEmail("demo@class.com")
                .providePassword("")
                .clickBtn();

        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());


        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickBtn();

        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.logIn();
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
}
