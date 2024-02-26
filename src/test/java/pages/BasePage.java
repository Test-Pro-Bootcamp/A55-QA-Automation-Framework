package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Web Elements and Methods used for most of the test

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }
    protected boolean waitForElementToBeNotVisible(WebElement userAvatarIcon) {
        boolean isWebElementNotVisible = false;
        try {
            isWebElementNotVisible = new WebDriverWait(driver, Duration.ofSeconds(2)).
                    until(ExpectedConditions.invisibilityOf(userAvatarIcon));
        }catch (TimeoutException e) {
            isWebElementNotVisible = true;
        }
        return isWebElementNotVisible;
    }

}
