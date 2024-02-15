package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web-Elements
    //private final By userAvatarIcon = By.cssSelector("img.avatar");
    @FindBy(css = "[class='avatar']")
    private WebElement userAvatarIcon;
    // private final By plusButton = By.cssSelector("#playlists > h1 > i");
    @FindBy(css = "#playlists > h1 > i")
    private WebElement plusButton;

    // private final By playlistNewBtn = By.cssSelector("#playlists > nav > ul > li:nth-child(1)");
    @FindBy(css = "#playlists > nav > ul > li:nth-child(1)")
    private WebElement playlistNewBtn;

    // private final By inputPlaylist = By.cssSelector("input[placeholder='↵ to save']");
    @FindBy(css = "input[placeholder='↵ to save']")
    private WebElement inputPlaylist;

    //private final By popUpMessage = By.cssSelector("div.success.show");
    @FindBy(css = "div.success.show")
    private WebElement popUpMessage;

    //private final By editBtn = By.xpath("//section[@id='playlists']//nav[@class='menu playlist-item-menu']//li[text()='Edit']");
    @FindBy(xpath = "//section[@id='playlists']//nav[@class='menu playlist-item-menu']//li[text()='Edit']")
    private WebElement editBtn;

    //private final By playlistName = By.cssSelector("input[data-testid='inline-playlist-name-input']");
    @FindBy(css = "input[data-testid='inline-playlist-name-input']")
    private WebElement playlistName;

    //private final By deletePlaylist = By.xpath("//button[@class='del btn-delete-playlist']");
    @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
    private WebElement deletePlaylist;

    private By lookupPlayListByByName(String name) {
        return By.xpath("//section[@id='playlists']//a[text()='" + name + "']");
    }
    //Helper Methods

    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }

    public HomePage clickPlusButton() {
        clickThroughActions(plusButton, 100);
        return this;
    }

    public HomePage clickNewPlayList() {
        click(playlistNewBtn);
        return this;
    }

    public HomePage enterPlaylistName(String name) {
        WebElement playlistNameField = findElement(inputPlaylist);
        playlistNameField.sendKeys(name);
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

    public void waitForMessage() {
        wait.until(ExpectedConditions.invisibilityOf(popUpMessage));
    }

    public String getNotification() {
        WebElement notificationMsg = findElement(popUpMessage);
        return notificationMsg.getText();
    }

    public void renamePlayList(String oldName, String newName) throws InterruptedException {
        WebElement playlist = findElement(lookupPlayListByByName(oldName));

        contextClickThroughActions(playlist, 100);

        click(findElement(editBtn));

        WebElement playlistNameField = findElement(playlistName);

        // hacking the removal of the old value for firefox
        String browser = System.getProperty("browser");
        switch (browser) {
            case "grid-firefox", "firefox":
                for (int i = 0; i < oldName.length(); i++)
                    playlistNameField.sendKeys(Keys.BACK_SPACE);
                playlistNameField.sendKeys(newName);
                break;
            default:
                playlistNameField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), newName);
        }

        playlistNameField.sendKeys(Keys.ENTER);
    }

    public HomePage selectPlayList(String name) {
        click(findElement(lookupPlayListByByName(name)));
        return this;
    }

    public HomePage clickDeleteButton() {
        WebElement deleteBtn = findElement(deletePlaylist);
        deleteBtn.click();
        return this;
    }
}