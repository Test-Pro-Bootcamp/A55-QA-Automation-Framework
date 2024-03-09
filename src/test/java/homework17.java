import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //Login
        //navigateToPage();
        String expectedSongAddedSuccessMessage = "Added 1 song into \"PlayListForDeleting1.\"";
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        //Thread.sleep(2000);

        //add song to Playlist
        searchSong("Dark");
        //Thread.sleep(2000);
        //click view all button
        clickViewAllBtn();
        //Thread.sleep(2000);
        //Select first Song
        selectFirstSongResult();
        //Thread.sleep(2000);
        //click add to button to add the song
        clikAddToBtn();
        //Thread.sleep(2000);
        //choose playlist
        choosePlaylist();
        //Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedSuccessMessage);
        //Thread.sleep(10000);
    }

    public String getAddToPlaylistSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
    public void choosePlaylist() {
        WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'PlayListForDeleting1')]"));
        playList.click();
    }

    public void clikAddToBtn() {
        WebElement clickAddBtn = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        clickAddBtn.click();

    }

    public void selectFirstSongResult() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']//td[@class='title'][1]"));
        firstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    // search for song and display results
    public void searchSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(songName);
        searchField.click();
        //Thread.sleep(2000);
    }



}
