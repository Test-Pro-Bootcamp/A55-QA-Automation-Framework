package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(css = "div.success.show")
    private WebElement notificationMsg;

    @FindBy(css = "[class='avatar']")
    private WebElement avatarIcon;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement userAvatar() {
        return avatarIcon;
    }
}
