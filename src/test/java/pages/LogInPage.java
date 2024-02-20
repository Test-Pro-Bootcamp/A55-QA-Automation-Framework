package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
    public LogInPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    //web elements
    //find elements by using @FindBy methos brovided by Page factori
    @FindBy(css = "[type = 'submit']")
    static WebElement submitButton;
    @FindBy(css= "[type='email']")
    static WebElement emailField;

    @FindBy(css = "[type = 'password']")
    static WebElement passwordField;

    //static By emailField= By.cssSelector("input[type='email']");
    //static By passwordField = By.cssSelector("input[type='password']");
    //static By submitButton= By.cssSelector("button[type='submit']");

    //helper methods
    public static void provideEmail(String email){
         //adjusting methods for Page factory
         emailField.sendKeys(email);
        //findElement(emailField).sendKeys(email);
    }
    public static void providePassword(String password){
        //Page factory method
        passwordField.sendKeys(password);
        //findElement(passwordField).sendKeys(password);
    }
    public static void clickSubmit(){
         submitButton.click();
        //findElement(submitButton).click();
    }

    public void login(){
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
    }
}
