import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork25 extends BaseTest {
    @Test
    public void launchParallel() {
        //GIVEN
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        //WHEN
        loginPage.loginMainPage();
        // THEN
        Assert.assertTrue(homePage.getUserAvatar());
    }

    @Test
    public void launchTest(){
        //GIVEN
        String homeList = "Homelist";
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        //WHEN
        loginPage.loginMainPage();
        //THEN
        Assert.assertTrue(homePage.getPlaylist());

    }

}
