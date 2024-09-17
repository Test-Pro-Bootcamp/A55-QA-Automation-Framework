package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    //Using Page Factory
    @FindBy(css= "[type='email']")
    WebElement emailField;
    @FindBy(css= "[type='password']")
    WebElement passwordField;
    @FindBy(css= "[type='submit']")
    WebElement submitBtn;
//Elements
    By soundBarVisualizer = By.xpath("//div//img[@alt='Sound bars']");
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void provideEmail(String email){
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        passwordField.sendKeys(password);
    }
    public void  clickSubmit(){
        submitBtn.click();

    }
    public void loginToKoelApp(){
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();
    }

    public void click(By locator){
        findElement(locator).click();
}
public void doubleClick(By locator){
        actions.doubleClick(findElement(locator)).perform();
}
    public boolean isSongPlaying() {
        //WebElement soundBarVisualizer = wait.until(ExpectedConditions
               // .visibilityOfElementLocated(By.xpath("//div//img[@alt='Sound bars']")));
        return findElement(soundBarVisualizer).isDisplayed();
    }
}



