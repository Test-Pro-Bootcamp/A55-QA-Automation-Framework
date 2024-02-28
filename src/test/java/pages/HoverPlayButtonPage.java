package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HoverPlayButtonPage extends BasePage{
    public HoverPlayButtonPage(WebDriver givenDriver) {
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
        WebElement hoverLocation = driver.findElement(By.xpath("//footer/div/span[@class=\"album-thumb-wrapper\"]"));
        actions.moveToElement(hoverLocation).build().perform();
        WebElement playButton = playBtn;
        Boolean playBtnDisplayed = playButton.isEnabled();
        Assert.assertTrue(playBtnDisplayed);
    }

    public void playButtonClick(){
        playBtn.click();
    }

}
