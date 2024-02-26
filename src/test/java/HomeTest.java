import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest{

    @Test
    public void renamePlaylist() {

        String updatedNameMsg = "Updated playlist \"Aurora.\"";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // step1: login to koel
        loginPage.login();
        //step2: double click on playlist
        homePage.doubleClickPlaylist();
        //step3: rename a playlist
        homePage.addNewNameToPlaylist();
        //step4: check if we rename the playlist
        Assert.assertEquals(homePage.playlistMsg(), updatedNameMsg);
    }
    @Test
    public void deletePlaylist(){
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Aurora.\"";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage ( driver);

        //Step1:Login to Koel
        loginPage.login();
        //Step2: Open a Playlist
        homePage.doubleClickPlaylist();
        //Step3: Click delete Btn
        homePage.clickDeletePlaylistBtn();
        // Step4: Assertion
        Assert.assertEquals(homePage.playlistMsg(), expectedPlaylistDeletedMessage);
    }

}
