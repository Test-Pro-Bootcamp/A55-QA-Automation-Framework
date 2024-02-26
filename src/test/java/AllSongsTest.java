import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest{

    @Test
    public void playSongByContextClick () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        BasePage basePage = new BasePage(driver);
        //Step1: Login to koel
        loginPage.login();
        // Step2: go to All Songs menu
        homePage.goToAllSongsList();
        //Step3: Right click on the first song
        allSongsPage.contextClickFirstSong();
        //Step4: choose play btn in the menu
        allSongsPage.choosePlayOption();
        //Assertions
        Assert.assertTrue(basePage.isSongPlaying());
    }

@Test
    public void playSong(){
    LoginPage loginPage = new LoginPage(driver);
    AllSongsPage allSongsPage = new AllSongsPage(driver);
    BasePage basePage = new BasePage(driver);
    //Login to koel
    loginPage.login();
    //click play button on the bottom of the page
    allSongsPage.clickPlay();
    //Assertions
    Assert.assertTrue(basePage.isSongPlaying());
}

}
