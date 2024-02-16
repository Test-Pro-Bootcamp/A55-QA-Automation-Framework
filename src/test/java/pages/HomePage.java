package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    String newPlaylistName1 = "VIVO";
    @FindBy(css = "div.success.show")
    private WebElement notificationMsg;

    @FindBy(css = "[class='avatar']")
    private WebElement avatarIcon;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylist;

    @FindBy(css = "[class='fa fa-plus-circle create']")
    private WebElement clickPlusButton1;

    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;
    @FindBy(xpath = "//section[@id='playlists']//li//a[contains(text(),'vivo')]")
    private WebElement playlist;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement userAvatar() {
        return avatarIcon;
    }

    public HomePage chooseNewPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(newPlaylist));
        newPlaylist.click();
        return this;
    }

    public HomePage clickPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickPlusButton1));
        clickPlusButton1.click();
        return this;
    }

    public String playlistCreated() {
        return findElement(notificationMsg).getText();

    }

    public HomePage enterPlaylistName(String newPlaylistName) {
        playlistNameField.clear();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage doubleClickPlaylist(){
        actions.doubleClick(findElement(playlist)).perform();
        return this;
    }

    public String playlistMsgSuccess() {
        wait.until(ExpectedConditions.visibilityOf(notificationMsg));
        return notificationMsg.getText();
    }


    public HomePage addNewNameToPlaylist() {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(newPlaylistName1);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }
}

