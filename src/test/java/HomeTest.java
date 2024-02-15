import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    String newPlayListName = "Sample Edited Playlist";

    @Test
    public void hoverOverPlayBtn() throws InterruptedException{
        //Login
        provideEmail("demo@class.com");
        provideEmail("te$t$tudent");
        logintoKoel();
        //Assertions
        Assert.assertTrue(hoverPlay().isDisplayed());
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("data-testid='play-btn']"))).isDisplayed());
    }

    @Test
    public void countSongsInPlaylist() {
        //Login
        provideEmail("demo@class.com");
        provideEmail("te$t$tudent");
        logintoKoel();
        //Choose playlist by the name
        choosePlayListByName("Testpro Playlist");
        //DisplayAllSongs
        displayAllSongs();
        //Assertions
        Assert.assertTrue(getPlayListDisplayed().contains(String.valueOf(countSongs())));
    }

    public void renamePlayList() throws InterruptedException {
        String newPlaylistName = "Sample Edited Playlist";
        String updatedPlaylistSuccessMsg = "Update playlist \"Sample Edited Playlist\"";
        provideEmail("demo@class.com");
        provideEmail("te$t$tudent");
        logintoKoel();
        //Thread.sleep(2000);
        //double click playList
        //doubleClickPlaylist();
        Thread.sleep(2000);
        //enter new name
        enterNewName();
        //assertion
        Assert.assertTrue(getRenamePlaylistSuccessMsg().contains(updatedPlaylistSuccessMsg));

    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE ));
        playListInputField.sendKeys(newPlayListName);
        playListInputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public String getPlayListDisplayed() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: " + countSongs());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void choosePlayListByName(String playListName) {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("a[contains(text(),'"+playListName+"')]"))).click();
    }

    public WebElement hoverPlay() throws InterruptedException {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        Thread.sleep(2000);
        return wait.until(ExpectedConditions.visibilityOf(play));
    }
}
