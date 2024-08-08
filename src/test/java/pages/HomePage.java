package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class HomePage extends BasePage {
    // userAvatarIcon: Represents the user avatar element on the page.
    @FindBy(css = ".avatar")
    private WebElement userAvatarIcon;

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement playlistIcon;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public String getUpdatedPlaylistMsg() {
        WebElement playListMsg = driver.findElement(cssSelector("div.success.show"));
        return playListMsg.getText();
    }
    public boolean getUserAvatar() {
        return userAvatarIcon.isEnabled();
    }

    public boolean getPlaylist() {
        return playlistIcon.isEnabled();
    }
    public void selectPlayList(String playlist) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement selectPlayListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        Actions action = new Actions(driver);

        action.
                doubleClick(selectPlayListElement).
                doubleClick(selectPlayListElement).
                sendKeys(selectPlayListElement, Keys.DELETE).perform();

        action.
                sendKeys(selectPlayListElement, playlist).
                sendKeys(Keys.ENTER).perform();

    }
}
