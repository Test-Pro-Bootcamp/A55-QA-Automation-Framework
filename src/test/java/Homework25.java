import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework25 extends BaseTest {

    String createdPlaylist = "Created playlist \"vivo.\"";
    String updatedPlaylistMsg = "Updated playlist \"VIVO.\"";


    @Test(priority = 0)
    public void createPlaylist() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logIn();
        homePage.clickPlusButton();
        homePage.chooseNewPlaylist();
        homePage.enterPlaylistName("vivo");
        Assert.assertEquals(homePage.playlistCreated(), createdPlaylist);


    }

    @Test(priority = 1)
    public void renamePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.logIn();
        homePage.doubleClickPlaylist();
        homePage.addNewNameToPlaylist();
        Assert.assertEquals(homePage.playlistMsgSuccess(), updatedPlaylistMsg);

    }

}

