package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HomePage extends BasePage{
    @FindBy(css = "[class='avatar']")
    private WebElement avatarIcon;
    @FindBy(css = "[class='view-profile']")
    private WebElement viewProfile;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
   public WebElement userAvatar(){
        wait.until(ExpectedConditions.visibilityOf(avatarIcon));
        return avatarIcon;
   }
    public HomePage openProfilePage(){
        wait.until(ExpectedConditions.visibilityOf(viewProfile)).click();
        return this;
    }
}
