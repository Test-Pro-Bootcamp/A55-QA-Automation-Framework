
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeleteMsg = "Deleted playlist \"First playlist.\"";

        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA55");
        loginToKoel();

        clickFirstplaylist();
        Thread.sleep(2000);
        clickXPlaylist();
        clickOkDeletePlaylistBtn();

        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeleteMsg);
    }

    public void clickFirstplaylist() {
        WebElement Firstplaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        Firstplaylist.click();
    }
    public void clickXPlaylist() {
        WebElement XPaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        XPaylist.click();
    }
    public void clickOkDeletePlaylistBtn(){
        WebElement OkDeletePlaylistBtn = driver.findElement(By.cssSelector(".ok"));
        OkDeletePlaylistBtn.click();
    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.hide"));
        return notificationMsg.getText();
    }

}
