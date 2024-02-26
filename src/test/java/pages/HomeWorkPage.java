package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeWorkPage extends BasePage{
    public HomeWorkPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Declare Elements using Page Factory
    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css ="[type='password']")
    WebElement passwordField;

    @FindBy(css ="[type='submit']")
    WebElement submitBtn;

    @FindBy(css="[title=\"Play or resume\"]")
    WebElement playPauseBtn;

    @FindBy(css="[data-testid=\"pause-btn\"]")
    WebElement pauseBtn;

    @FindBy(css="[data-testid=\"play-btn\"]")
    WebElement playBtn;

    public void login(){
        emailField.sendKeys("nayana.rao.subramanya@testpro.io");
        passwordField.sendKeys("Zqmvyk4hDaZ3vga");
        submitBtn.click();
    }

    public void hoverPlay(){
        actions.moveToElement(playPauseBtn).build().perform();
        Assert.assertTrue(playBtn.isDisplayed());
    }

    public void playButtonClick(){
        playBtn.click();
    }

}
