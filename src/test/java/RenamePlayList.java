import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class RenamePlayList extends BaseTest {

    LoginPage loginPage;

    HomePage homePage;

    @BeforeSuite
    @Parameters({"BaseURL", "Email", "Password"})
    void renamePlaylistBeforeSuite(String baseURL, String email, String password) {
        baseBeforeSuite();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.login(baseURL, email, password);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @AfterSuite
    void renamePlaylistAfterSuite() {
        baseAfterSuite();
    }

    @Test
    @Parameters({"PlayList"})
    public void renamingPlayList(String playlist) {
        homePage.clickPlusButton();
        homePage.clickNewPlayList();
        homePage.enterPlaylistName(playlist);


        String createdMsg = "Created playlist \"" + playlist + ".\"";
        Assert.assertEquals(homePage.getNotification(), createdMsg);

        homePage.waitForMessage();

        String newName = playlist + "-renamed";
        homePage.renamePlayList(playlist, newName);

        String message = "Updated playlist \"" + newName + ".\"";
        Assert.assertEquals(homePage.getNotification(), message);

        homePage.waitForMessage();

        //Click the playlist you want to rename.
        homePage.selectPlayList(newName);
        homePage.clickDeleteButton();

        //  Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
        message = "Deleted playlist \"" + newName + ".\"";
        Assert.assertEquals(homePage.getNotification(), message);
    }

}
