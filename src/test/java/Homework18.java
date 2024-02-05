import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {


        navigateToPage("https://qa.koel.app/");
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA55");
        loginToKoel();

        Thread.sleep(5000);

        searchSong("summer breeze");
        Thread.sleep(5000);

        clickViewAllBtn();
        Thread.sleep(5000);

        clickFirstSongResult();
        Thread.sleep(5000);

        clickAddToBtn();
        Thread.sleep(5000);

        choosePlaylist();
        Thread.sleep(5000);

        Assert.assertEquals(getSongAddedSuccessMsg(),expectedSongAddedSuccessMsq);
        Thread.sleep(5000);


    }
