import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{
    @Test
    public void deletePlayList() throws InterruptedException {
        String expectedPlayListMsg = "Deleted playlist \"PlayListForDeleting1.\"";

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        selectPlayList();
        clickDeletePlayList();
        Thread.sleep(2000);
        submitAlertToDeletePlaylist();
        // Asserts
        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlayListMsg);
    }

    public void submitAlertToDeletePlaylist() {
        WebElement submitAlert = driver.findElement(By.cssSelector("button.ok"));
        submitAlert.click();
    }

    public void clickDeletePlayList() {
        WebElement playListElement = driver.findElement(By.xpath("//section[@id='playlistWrapper']//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']"));
        playListElement.click();

    }

    public void selectPlayList(){
        WebElement selectPlayListElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        selectPlayListElement.click();
    }

    public String getDeletedPlaylistMsg(){
        WebElement playlistMsg = driver.findElement(By.cssSelector("div.success.show"));
        return playlistMsg.getText();
    }
    

}
