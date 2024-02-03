import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    String DeleteMessage = "Deleted playlist \"vivo.\"";
    String createdPlaylist = "Created playlist \"vivo.\"";

    @Test
    public void createPlaylist() throws InterruptedException {
        //Given
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickBtn();
        //When
        clickPlusButton();
        chooseNewPlaylist();
        enterPlaylistName("vivo");
        //Then
        Thread.sleep(5000);
        Assert.assertEquals(playlistCreated(), createdPlaylist);

    }

    @Test

    public void deletePlaylist() throws InterruptedException {
        //Given
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickBtn();
        //WHEN
        //open playlist
        choosePlaylist();
        //delete playlist
        clickDeleteButton();
        //Then
        Thread.sleep(5000);
        Assert.assertEquals(DeleteMsg(), DeleteMessage);
    }

    public String playlistCreated() {
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }

    private void enterPlaylistName(String newPlaylistName) {
        WebElement playlistNameField = driver.findElement(By.cssSelector("[name='name'] "));
        playlistNameField.clear();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }

    private void chooseNewPlaylist() {
        WebElement newPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();
    }

    private void clickPlusButton() {
        WebElement clickPlusButton1 = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        clickPlusButton1.click();
    }

    public String DeleteMsg() {
        WebElement msg = driver.findElement(By.cssSelector("div.success.show"));
        return msg.getText();
    }

    public void clickDeleteButton() {
        WebElement DeleteBtn = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        DeleteBtn.click();
    }

    private void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//a[contains(text(),'vivo')]"));
        playlist.click();
    }

}
