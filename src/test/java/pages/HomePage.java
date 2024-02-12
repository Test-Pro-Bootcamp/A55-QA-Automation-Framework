package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web-Elements
    private final By userAvatarIcon = By.cssSelector("img.avatar");
    private final By plusButton = By.cssSelector("#playlists > h1 > i");
    private final By playlistNewBtn = By.cssSelector("#playlists > nav > ul > li:nth-child(1)");
    private final By inputPlaylist = By.cssSelector("input[placeholder='↵ to save']");
    private final By popUpMessage = By.cssSelector("div.success.show");
    private final By editBtn = By.xpath("//section[@id='playlists']//nav[@class='menu playlist-item-menu']//li[text()='Edit']");
    private final By playlistName = By.cssSelector("input[data-testid='inline-playlist-name-input']");
    private final By deletePlaylist = By.xpath("//button[@class='del btn-delete-playlist']");

    private By lookupPlayListByByName(String name) {
        return By.xpath("//section[@id='playlists']//a[text()='"+ name +"']");
    }
    //Helper Methods

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void clickPlusButton() {
        WebElement btn = driver.findElement(plusButton);

        actions.moveToElement(btn).build().perform();
        actions.pause(100).build().perform();
        actions.click(btn).build().perform();
    }

    public void clickNewPlayList() {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistNewBtn));
        newPlaylist.click();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistNameField = driver.findElement(inputPlaylist);
        playlistNameField.clear();
        playlistNameField.sendKeys(name);
        playlistNameField.sendKeys(Keys.ENTER);
    }

    public void waitForMessage() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpMessage));
    }

    public String getNotification() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMessage));
        return notificationMsg.getText();
    }

    public void  renamePlayList (String oldName, String newName) {
        WebElement playlist = driver.findElement(lookupPlayListByByName(oldName));

        actions.moveToElement(playlist).build().perform();
        actions.pause(100).build().perform();
        actions.contextClick(playlist).build().perform();

        WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(editBtn));
        edit.click();

        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistName));
        playlistNameField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), newName);
        playlistNameField.sendKeys(Keys.ENTER);
    }

    public void selectPlayList(String name) {
        WebElement playlistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(lookupPlayListByByName(name)));
        playlistBtn.click();
    }

    public void clickDeleteButton() {
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(deletePlaylist));
        deleteBtn.click();
    }
}