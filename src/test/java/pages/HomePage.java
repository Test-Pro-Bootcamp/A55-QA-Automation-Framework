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
    //Web Elements
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By doubleClickLocator = By.xpath("//a[normalize-space()='pop']");

    private By inputField = By.cssSelector("[name='name']");
    private By notificationMsg1 = By.cssSelector("div.success.show");

    //Helper Methods
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
    public void doubleClickPlaylist() {
        WebElement doubleClickElement = driver.findElement(doubleClickLocator);
        actions.doubleClick(doubleClickElement).perform();
    }
    public void addNewNameToPlaylist() {
        WebElement inputFieldElement = driver.findElement(inputField);
        inputFieldElement.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputFieldElement.sendKeys("Test Playlist1");
        inputFieldElement.sendKeys(Keys.ENTER);
    }

    public String playlistMsg() {
        WebElement notificationMsg = driver.findElement(notificationMsg1);
        return notificationMsg.getText();
    }

}
