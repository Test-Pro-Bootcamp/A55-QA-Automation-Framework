import org.testng.annotations.Test;
import pages.HomeWorkPage;

public class HomeWorkTest extends BaseTest{
    @Test
    public void hoverOverPlay(){
        HomeWorkPage homeWorkPage = new HomeWorkPage(driver);

        homeWorkPage.login();
        homeWorkPage.navigateToAllSongsPage();
        homeWorkPage.hoverPlay();
        homeWorkPage.playButtonClick();
        homeWorkPage.isSongPlaying();
    }
}
