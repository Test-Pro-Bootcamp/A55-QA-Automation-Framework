package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends BasePage{
    public LogInPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    //web elements
    static By emailField= By.cssSelector("input[type='email']");
    static By passwordField = By.cssSelector("input[type='password']");
    static By submitButton= By.cssSelector("button[type='submit']");

    //helper methods
    public static void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public static void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public static void clickSubmit(){

        findElement(submitButton).click();
    }

    public void login(){
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
    }
}
