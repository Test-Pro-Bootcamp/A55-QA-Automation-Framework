import org.testng.annotations.Test;
import pages.PauseSongPage;

public class PauseSongTest extends BaseTest{
    @Test
    public void pauseSongFromAllSongs(){
        PauseSongPage pauseSongPage = new PauseSongPage(driver);
        pauseSongPage.login();
        pauseSongPage.navigateToAllSongsPage();
        pauseSongPage.doubleClickFirstSongAndPlay();
        pauseSongPage.pauseSong();
    }
}
