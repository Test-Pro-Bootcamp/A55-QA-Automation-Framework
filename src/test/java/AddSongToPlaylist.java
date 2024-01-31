
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class AddSongToPlaylist extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedMessage = "Added 1 song into \"Homework17.\"";

        navigateToPage();
        provideEmail("ana.nicora@testpro.io");
        providePassword("QaKoelApp_1234");
        clickSubmit();
        Thread.sleep(2000);

        //Search for a song (choose any song of your choice).
        searchSong("Episode 2");
        //Click 'View All' button to display the search results.
        clickViewAll();
        //Click the first song in the search results.
        clickFirstSong();
        //Click 'ADD TO...' button.
        clickAddButton();

        //Choose the playlist to add it to, (you can create a new one with a unique name).
        choosePlaylist();

        Thread.sleep(2000);

        // Verify that a notification message appears and contains the text, "Added 1 song into {your playlist}".
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedMessage);
    }

    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(song);
    }

    public void clickViewAll() {
        WebElement submit = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        submit.click();
    }

    public void clickFirstSong() {
        WebElement d = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        d.click();
    }

    public void clickAddButton() {
        WebElement addButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addButton.click();
    }

    public void choosePlaylist() {
        WebElement playlistName = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section[@class='existing-playlists']//li[@class='playlist']"));
        playlistName.click();
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }

}





