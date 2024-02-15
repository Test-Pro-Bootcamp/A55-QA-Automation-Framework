package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * this class has Page Factory
 * login helper methods are using the Page Factory
 */
public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    //Using Page factory

    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement submitBtn;

    //Elements
    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");


    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

/*
    public void provideEmail(String email){
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        submitBtn.click();
    }

    public void loginToKoelApp() {
        provideEmail("demo@class.com");
        provideEmail("te$t$tudent");
        clickSubmit();
    }
*/
public BasePage provideEmail(String email){
    emailField.sendKeys(email);
    return this;
}

public BasePage providePassword(String password){
    passwordField.sendKeys(password);
    return this;
    }
 public BasePage clickSubmit() {
    submitBtn.click();
     return this;
    }


    public boolean isSongPlaying() {
        //WebElement soundBarVisualizer = wait.until(ExpectedConditions
                //.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return findElement(soundBarVisualizer).isDisplayed();
    }





}

