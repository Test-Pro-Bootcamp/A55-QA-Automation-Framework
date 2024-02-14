package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    public BasePage(WebDriver givenDriver){
      driver = givenDriver;
      wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      actions = new Actions(driver);

      PageFactory.initElements(driver, this);
    }

    protected WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findElement(WebElement elem){
        return wait.until(ExpectedConditions.visibilityOf(elem));
    }
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void clickThroughActions(WebElement element, int wait) {
        actions.moveToElement(element).build().perform();
        if (wait > 0) {
            actions.pause(wait).build().perform();
        }
        actions.click(element).build().perform();
    }

    protected void contextClickThroughActions(WebElement element, int wait) {
        actions.moveToElement(element).build().perform();
        if (wait > 0) {
            actions.pause(wait).build().perform();
        }
        actions.contextClick(element).build().perform();
    }

    protected void contextClick(WebElement element) {
        actions.contextClick(findElement(element)).perform();
    }
    protected void doubleClick(WebElement element) {
        actions.doubleClick(findElement(element)).perform();
    }
}

