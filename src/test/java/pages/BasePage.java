package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected By emailField = By.cssSelector("[type=\"email\"]");
    protected By passwordField = By.cssSelector("[type=\"password\"]");
    protected By submitBtn = By.cssSelector("[type=\"submit\"]");
    protected By allSongsPage = By.cssSelector("[href=\"#!/songs\"]");
    protected By progressPaneSong = By.xpath("//div[@id='progressPane']/h3[@class='title']");
    protected By naviagateToHomePage = By.cssSelector("[href=\"#!/home\"]");
    protected By CurrentQueuePage = By.cssSelector("[href=\"#!/queue\"]");

    protected By pauseBtn = By.cssSelector("[data-testid=\"pause-btn\"]");

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void navigateToAllSongsPage(){
        WebElement allSong = findElement(allSongsPage);
        allSong.click();
    }
    public void naviagteToHomePage(){
        WebElement homePage = findElement(naviagateToHomePage);
        homePage.click();
    }
    public void navigateToQueuePage(){
        WebElement queuePg = findElement(CurrentQueuePage);
        queuePg.click();
    }

    public void isSongPlaying(){
        WebElement pauseButton = findElement(pauseBtn);
        Assert.assertTrue(pauseButton.isDisplayed());
    }

}
