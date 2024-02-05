import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedSuccessMsq = "Added 1 song into \"first playlist.\"";

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

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void clickViewAllBtn() {
        WebElement clickViewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        clickViewAllBtn.click();
    }

    public void clickFirstSongResult() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void choosePlaylist() {
        WebElement choosePlayList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section[@class='existing-playlists']//li[5]"));
        choosePlayList.click();
    }

    public String getSongAddedSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

}
