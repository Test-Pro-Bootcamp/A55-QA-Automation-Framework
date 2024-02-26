package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Web Elements

    @FindBy(css = "[type='email']")
    private WebElement emailField;

    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    private WebElement loginBtn;

    //Helper Methods
    public LoginPage provideEmail (String email){
        emailField.sendKeys(email);
        return this;
    }

public LoginPage providePassword (String password){
    passwordField.sendKeys(password);
    return this;
}

public LoginPage clickSubmit(){
    loginBtn.click();
    return this;}
public void login(){
     provideEmail("nicolai.luta@testpro.io");
     providePassword("tAPO0uuR");
     clickSubmit();

    }

}
