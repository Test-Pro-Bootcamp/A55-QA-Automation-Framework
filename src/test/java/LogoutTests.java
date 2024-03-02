import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LogoutTests extends BaseTest{
    @Test(priority = 10)
public void logoutButtonIsPresent(){
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());

    loginPage.provideEmail("taqimed999@gmail.com")
            .providePassword("Student@1999")
            .clickBtn();
    Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }
    @Test(priority = 11)

    public void logoutAndRedirectToLoginPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("taqimed999@gmail.com")
                .providePassword("Student@1999")
                .clickBtn();
        homePage.clickLogOut();
        Assert.assertTrue(loginPage.getRegistrationButton().isDisplayed());
    }
    @Test(priority = 12)

    public void updateEmailAndLogout(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("taqimed999@gmail.com")
                .providePassword("Student@1999")
                .clickBtn();
        homePage.openProfilePage();
        profilePage.addCurrentPassword("Student@1999");
        profilePage.addNewEmail("taqimed99@gmail.com");
        profilePage.clickLogOut1();
        Assert.assertTrue(loginPage.getRegistrationButton().isDisplayed());
    }
    @Test(priority = 13)

    public void updatePasswordAndLogout() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("taqimed99@gmail.com")
                .providePassword("Student@1999")
                .clickBtn();
        homePage.openProfilePage();
        profilePage.addCurrentPassword("Student@1999");
        profilePage.addNewPassword("Med-20115-010499@");
        profilePage.clickLogOut1();
        Assert.assertTrue(loginPage.getRegistrationButton().isDisplayed());
    }

}
