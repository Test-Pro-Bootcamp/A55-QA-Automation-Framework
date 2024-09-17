package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    String newPlaylistName1 = "Test22";

    //Web Elements
   /* By userAvatarIcon = By.cssSelector("img.avatar");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    By allSongsList = By.xpath("//a[@class='songs']");
    //Helper Method

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
public void doubleClickPlaylist(){
        doubleClick(firstPlaylist);
}
public void enterNewName(String playlistName ){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
}
 public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();

 }
    public void chooseAllSongsList() {
        findElement(allSongsList).click();
    }
}*/
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;

    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;

    @FindBy(css = "div.success.show")
    private WebElement renamePlaylistSuccessMsg;

    @FindBy(xpath = "//a[@class='songs']")
    private WebElement allSongsList;



    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public void doubleClickPlaylist() {
        // Implementation for double clicking the first playlist
    }

    public void enterNewName(String playlistName) {
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        playlistNameField.sendKeys(playlistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        return renamePlaylistSuccessMsg.getText();
    }

    public void chooseAllSongsList() {
        allSongsList.click();
    }
}