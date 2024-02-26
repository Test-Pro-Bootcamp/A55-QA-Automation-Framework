package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Web Elements using Page Factory

    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(xpath ="//a[normalize-space()='dance']" )
    private WebElement doubleClickLocator;
    @FindBy(css = "[name='name']")
    private WebElement playlistNameField;
    @FindBy(css = "div.success.show")
    private WebElement nottnotificationMsg;


    //Helper Methods
    public WebElement getUserAvatar(){
        return userAvatarIcon;
    }
    public HomePage doubleClickPlaylist() {
        actions.doubleClick((doubleClickLocator)).perform();
        return this;
    }
    public HomePage addNewNameToPlaylist() {
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistNameField.sendKeys("Test Playlist");
        playlistNameField.sendKeys(Keys.ENTER);
        return this;
    }

   public String playlistMsg() {
     return nottnotificationMsg.getText();
    }

}
