import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork extends BaseTest{

    @Test
    public void renameSmartPlaylist(){
        //Step1: login to the website.
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        avatarIsDisplayed();

        WebElement playlistSmart = driver.findElement(By.xpath("//*[@id=\"playlists\"]//a[contains(@href,'70585')]"));

        actions.moveToElement(playlistSmart).contextClick(playlistSmart).build().perform();
        editButtonClick();
        renameTheSmartPlaylist();
        //Step: Click on the Save button using xpath //div[@class="smart-playlist-form"]//footer/button[@type="submit"]
        saveSmartPlaylist();
        //Step: Confirm Success message using notification xpath: //div[@class="alertify-logs top right"]/div[@class='success show']
        successMessageSmartPlaylistIsDisplayed();
    }
    @Test
    public void renamePlaylist(){
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        renamePlaylistAction();

        //Step: Confirm we received the notification "Updated playlist \"New Playlist.\""
        String successMessage = "Updated playlist \"New name.\"";
        WebElement messageOfSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class='success show']")));
        Assert.assertEquals(messageOfSuccess.getText(),successMessage);
    }

}
