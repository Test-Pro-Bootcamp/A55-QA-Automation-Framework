import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    String unableToLogin="Password is incorrect";
    String emailUpdatedSuccessfully="Profile updated.";
    String passwordUpdatedSuccessfully="Profile updated.";

    @Test(priority = 0)
public void loginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

         loginPage.provideEmail("taqimed99@gmail.com")
                 .providePassword("Med-20115-010499@")
                 .clickBtn();
         Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
    @Test(priority = 1)
    public void loginWithInvalidEmailAndValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("taqimed999@gmail.com")
                .providePassword("Med-20115-010499@")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatarIsNotVisible());
    }
    @Test(priority = 2)
    public void loginWithValidEmailAndInvalidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("taqimed99@gmail.com")
                .providePassword("Student@199")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatarIsNotVisible());
    }
    @Test(priority = 3)
    public void loginWithEmptyEmailAndEmptyPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("")
                .providePassword("")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatarIsNotVisible());
    }
    @Test(priority = 4)
    public void updateEmail(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("taqimed99@gmail.com")
                .providePassword("Med-20115-010499@")
                .clickBtn();
        homePage.openProfilePage();
        profilePage.addCurrentPassword("Med-20115-010499@");
        profilePage.addNewEmail("taqimed999@gmail.com");
        //profilePage.clickSaveBtn();
        Assert.assertEquals(profilePage.emailHasUpdated(),emailUpdatedSuccessfully);
    }
    @Test(priority = 5)
    public void loginWithUpdatedEmail(){
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());

            loginPage.provideEmail("taqimed999@gmail.com")
                    .providePassword("Med-20115-010499@")
                    .clickBtn();
            Assert.assertTrue(homePage.userAvatar().isDisplayed());
        }
        @Test(priority = 6)
    public void loginWitholdEmail(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("taqimed99@gmail.com")
                .providePassword("Med-20115-010499@")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatarIsNotVisible());
      }
    @Test(priority = 7)
    public void updatePassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());

        loginPage.provideEmail("taqimed999@gmail.com")
                .providePassword("Med-20115-010499@")
                .clickBtn();
        homePage.openProfilePage();
        profilePage.addCurrentPassword("Med-20115-010499@");
        profilePage.addNewPassword("Student@1999");
        //profilePage.clickSaveBtn();
        Assert.assertEquals(profilePage.passwordHasBeenUpdated(),passwordUpdatedSuccessfully);

    }
    @Test(priority = 8)
    public void loginWithUpdatedPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("taqimed999@gmail.com")
                .providePassword("Student@1999")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatar().isDisplayed());
    }
    @Test(priority = 9)
    public void loginWitholdPassword(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("taqimed999@gmail.com")
                .providePassword("Med-20115-010499@")
                .clickBtn();
        Assert.assertTrue(homePage.userAvatarIsNotVisible());
    }

}

