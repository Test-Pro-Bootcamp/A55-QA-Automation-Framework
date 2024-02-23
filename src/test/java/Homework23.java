import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework22 extends BaseTest {

    @Test
    public void deletePlaylist() {
        String expectedPlayListDeleteMsg="Deleted playlist\"First user playlist.\"";

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        logintoKoel();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlayListMsg(),expectedPlayListDeleteMsg);

    }
    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement submitBtn;

    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    public Object getDeletedPlayListMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }

    public void openPlaylist() {
        WebElement playlistToOpen = driver.findElement(By.cssSelector(".playlist:nth-child(5)"));
        playlistToOpen.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylist.click();
        Thread.sleep(2000);
    }
}
