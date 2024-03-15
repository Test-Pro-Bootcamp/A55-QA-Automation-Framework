package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Web Elements;

    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsList = By.cssSelector("li a.songs");

    String newPlaylistName = "Sample Playlist";


    @FindBy(xpath = "//a[contains(text(),'Oreo')]")
    WebElement playListName;
    @FindBy(xpath = "//button[@title= 'Delete this playlist']")
    WebElement deletePlaylistBtn;

    @FindBy(css = "div.success.show")
    WebElement notification;

    String deletedPlaylistSuccessMessage = "Deleted playlist \"Oreo.\"";

    @FindBy(xpath = "//section[@id='songsWrapper']//li[contains(text(),'Green Song')]")
    WebElement selectPlayListName;
    @FindBy(xpath = "//button[@class='btn-add-to']")
    WebElement addSongBtn;
    @FindBy(xpath = "//section[@id='songsWrapper']//tr[@class='song-item'][1]")
    WebElement clickFirstSong;
    @FindBy(xpath = "//a[@class='songs active']")
    WebElement viewAllSongs;
    @FindBy(css = "div.success.show")
    WebElement getSongAddedSuccessMessage;

////section[@id='songResultsWrapper']//li[contains(text(),'Green Song')]



    //Helper Method;

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

    public void chooseAllSongsList() {
        findElement(allSongsList).click();

    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }


    public void selectPlaylist() {
        //WebElement playlistName = driver.findElement(By.xpath("//a[contains(text(),'Oreo')]"));/
        playListName.click();

    }

    public void clickDeletePlaylistBtn() {

        // WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title= 'Delete this playlist']")));
        deletePlaylistBtn.click();
    }

    public boolean getPlaylistDeletedMessage() {
        // WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.isDisplayed();
    }


    public void choosePlaylist() {
        selectPlayListName.click();
    }

    public void clickAddToBtn() {
        addSongBtn.click();
    }

    public void selectFirstSong() {
        clickFirstSong.click();
    }

    public void clickViewAllBtn() {
        viewAllSongs.click();
    }
    public Boolean getSongAddedSuccessMessage(){
        WebElement  getSongAddedSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return getSongAddedSuccessMessage.isDisplayed();

    }
    }

