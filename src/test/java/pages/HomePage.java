package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    String newPlaylistName1 = "VIVO";

    By avatarIcon = By.cssSelector("[[class='avatar']]");
    By newPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By clickPlusButton1 = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By playlistNameField = By.cssSelector("[name='name']");
    By notificationMsg = By.cssSelector("div.success.show");
    By playlist = By.xpath("//section[@id='playlists']//li//a[contains(text(),'vivo')]");


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement userAvatar() {
        return findElement(avatarIcon);
    }

    public void chooseNewPlaylist() {
        findElement(newPlaylist).click();
    }

    public void clickPlusButton() {
        findElement(clickPlusButton1).click();
    }

    public String playlistCreated() {
        return findElement(notificationMsg).getText();

    }

    public void enterPlaylistName(String newPlaylistName) {
        findElement(playlistNameField).clear();
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        actions.doubleClick(findElement(playlist)).perform();
    }

    public String playlistMsgSuccess() {
        return findElement(notificationMsg).getText();
    }


    public void addNewNameToPlaylist() {
      /*  WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName1);
        inputField.sendKeys(Keys.ENTER);
    }*/
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(newPlaylistName1);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
}
