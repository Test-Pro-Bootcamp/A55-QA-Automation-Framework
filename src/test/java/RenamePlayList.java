import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class RenamePlayList extends BaseTest {

    private LoginPage loginPage;

    private HomePage homePage;

    @BeforeSuite
    @Parameters({"BaseURL", "Email", "Password"})
    void beforeSuite(String baseURL, String email, String password) throws MalformedURLException {
        initChromeDriver();

        loginPage = new LoginPage(driverThreadLocal.get());
        homePage = new HomePage(driverThreadLocal.get());

        loginPage.login(baseURL, email, password);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @AfterSuite
    void afterSuite() {
        quitChromeDriver();
    }

    @Test
    @Parameters({"PlayList"})
    public void renamingPlayListTest(String playlist) throws InterruptedException {
        homePage.clickPlusButton()
                .clickNewPlayList()
                .enterPlaylistName(playlist);


        String createdMsg = "Created playlist \"" + playlist + ".\"";
        Assert.assertEquals(homePage.getNotification(), createdMsg);

        homePage.waitForMessage();

        String newName = playlist + "-renamed";
        homePage.renamePlayList(playlist, newName);

        String updatedMsg = "Updated playlist \"" + newName + ".\"";
        Assert.assertEquals(homePage.getNotification(), updatedMsg);

        homePage.waitForMessage();

        //Click the playlist you want to rename.
        homePage.selectPlayList(newName)
                .clickDeleteButton();

        //  Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
        String deletedMsg = "Deleted playlist \"" + newName + ".\"";
        Assert.assertEquals(homePage.getNotification(), deletedMsg);
    }

}
