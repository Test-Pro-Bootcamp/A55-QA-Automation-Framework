import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;

public class Homework24 extends BaseTest {

    String createdPlaylist = "Created playlist \"vivo.\"";
    String updatedPlaylistMsg = "Updated playlist \"VIVO.\"";


    @Test
    public void createPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.clickPlusButton();
        homePage.chooseNewPlaylist();
        homePage.enterPlaylistName("vivo");
        Assert.assertEquals(homePage.playlistCreated(), createdPlaylist);


    }

    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.doubleClickPlaylist();
        homePage.addNewNameToPlaylist();
        Assert.assertEquals(homePage.playlistMsgSuccess(), updatedPlaylistMsg);

    }

}

