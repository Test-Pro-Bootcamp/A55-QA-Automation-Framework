import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class Homework21 extends BaseTest {
    String newPlaylistName1 = "VIVO";
    String createdPlaylist = "Created playlist \"vivo.\"";

    @Test
    public void createPlaylist() {
        //Given
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickBtn();
        //When
        clickPlusButton();
        chooseNewPlaylist();
        enterPlaylistName("vivo");
        Assert.assertEquals(playlistCreated(), createdPlaylist);

    }

    @Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"VIVO.\"";
        //Given
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickBtn();
        //When
        doubleClickPlaylist();
        addNewNameToPlaylist();
        //Then
        Assert.assertEquals(playlistMsgSuccess(), updatedPlaylistMsg);

    }

    public String playlistMsgSuccess() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();

    }

    public void addNewNameToPlaylist() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName1);
        inputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li//a[contains(text(),'vivo')]")));
        actions.doubleClick(playlist).perform();
    }

    public String playlistCreated() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();

    }

    public void enterPlaylistName(String newPlaylistName) {
        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name'] ")));
        playlistNameField.clear();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }

    public void chooseNewPlaylist() {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
    }

    public void clickPlusButton() {
        WebElement clickPlusButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        clickPlusButton1.click();
    }

}
