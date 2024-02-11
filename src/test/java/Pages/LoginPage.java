package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super (givenDriver);

    }

    //Web Elements

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginBtn = By.cssSelector("button[type='submit']");

}

//Helper Methods

public void provideEmail(String email){
    findElement(emailField).sendkeys(email);
    }

    public void clickSubmit() {
    findElement(loginBtn).click();

    public void login() {
            provideEmail("demo@class.com");
            provideEmail("te$t$tudent");
            logintoKoel();
        }
}