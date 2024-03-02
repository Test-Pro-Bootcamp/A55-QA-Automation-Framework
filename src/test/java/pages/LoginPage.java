package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    @FindBy(css ="[href='registration']")
    private WebElement registrationButton;
    @FindBy(css = "[type='email']")
    private WebElement emailField;

    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    private WebElement clickBtn1;
    @FindBy(css = "div.success.show")
    private WebElement unableToLoginMsg;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickBtn() {
        wait.until(ExpectedConditions.visibilityOf(clickBtn1));
        clickBtn1.click();
        return this;
    }

    public LoginPage logIn() {
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickBtn();
        return this;
    }
    public String loginFailedMsg(){
        wait.until(ExpectedConditions.visibilityOf(unableToLoginMsg));
        return unableToLoginMsg.getText();
    }
    public WebElement getRegistrationButton(){
        wait.until(ExpectedConditions.visibilityOf(registrationButton));
        return registrationButton;
    }
}


