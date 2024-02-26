package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }
    //Web Elements

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css =".playlist:nth-child(3)")
    private WebElement firstPlaylist;
    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;

    @FindBy(css = "div.success.show")
    private WebElement notificationMsg;

    //web elements for create a playlist

    @FindBy (css = "[data-testid='sidebar-create-playlist-btn']")
    private WebElement clickPlusButton1;
    @FindBy (css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylistBtn;
    @FindBy (css = "[name='name']")
    private WebElement getPlaylistNameField;
    @FindBy (css = "li a.songs")
    private WebElement allSongs;


    //Helper Methods
    public WebElement getUserAvatar(){
        return userAvatarIcon;
    }

    public void doubleClickPlaylist() {
        actions.doubleClick(firstPlaylist).perform();
    }
    public HomePage addNewNameToPlaylist() {
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistNameField.sendKeys("Aurora");
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }
    public String playlistMsg() {
        return notificationMsg.getText();
    }
    public HomePage openPlaylist(){
        firstPlaylist.click();
        return this;
    }
    public HomePage clickDeletePlaylistBtn(){
        deleteBtn.click();
        return this;
    }
    @FindBy (css = ".btn-delete-playlist")
    private WebElement deleteBtn;
    public HomePage goToAllSongsList(){
        allSongs.click();
        return this;
    }
    //Method for Invalid Login Test
    public boolean isNotVisibleAvatarIcon(){
        return waitForElementToBeNotVisible(userAvatarIcon);
    }

}

