
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;
import org.openqa.selenium.ElementNotInteractableException;
@Test
public class Homework17 extends BaseTest{


    public void addSong() throws InterruptedException {
        String expectedMessage = "Added 1 song into \"first playlist.\"";

        // Step1: navigate to koel page
        navigateToPage();
        //Step2: login to koel app
        provideEmail("nicolai.luta@testpro.io");
        providePassword("tAPO0uuR");
        loginToKoel();
        //Step3: search for a song
        searchSong("day");
        //Step4: click 'view all' button
        clickViewAllBtn();
        //Step5: Select first song
        firstSongResults();
        //Step6: click 'add to' button
        clickAddToBtn();
        //Step7: choose the playlist 'first playlist'
        choosePlaylist();
        //Step8: check if we get the correct mesage / Assertions
        Assert.assertEquals(getAddToPlaylistSuccessMsg(),expectedMessage);
    }
    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addTo = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addTo.click();
    }

    public void firstSongResults() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@class='songs']//span[@class='details']"));
        firstSong.click();

    }

    public void clickViewAllBtn() {
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[placeholder='Press F to search']"));
        searchField.sendKeys(song);
    }


}
