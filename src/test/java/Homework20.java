import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;


public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() {
        String expectedPlayListDeleteMsg="Deleted playlist\"First user playlist.\"";

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        logintoKoel();
        //open Playlist
        openPlaylist();
        clickDeletePlaylistBtn();
       // Assert.assertEquals(getDeletedPlayListMsg(),expectedPlayListDeleteMsg);


    }

    public void openPlaylist() {
        //WebElement playlistToOpen = driver.findElement(By.cssSelector(".playlist:nth-child(5)"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(5)")));
        playlistToOpen.click();
    }

    public void clickDeletePlaylistBtn() {
        //WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }

    public Object getDeletedPlayListMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        return notificationMsg.getText();
    }
}
