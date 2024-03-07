import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PlaySongPage;

public class PlaySongTest extends BaseTest{

    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        PlaySongPage playSongPage = new PlaySongPage(driver);

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();

        basePage.navigateToAllSongsPage();

        playSongPage.contextClickFirstSongAndPlay();

        basePage.isSongPlaying();

    }
}
