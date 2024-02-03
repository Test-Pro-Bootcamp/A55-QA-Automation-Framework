import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        String expectedSongAddedSuccessMessage = "Added 1 song into \"first playlist.\"";

        navigateToPage();
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA55");
        loginToKoel();

        searchForSong("Summer breeze");
        clickViewAllBtn();
        clickFirstSongResult();
        clickAddToBtn();
        choosePlayList();

        Assert.assertEquals(getAddToPlaylistSuccesMsg(),expectedSongAddedSuccessMessage);


    }

}
