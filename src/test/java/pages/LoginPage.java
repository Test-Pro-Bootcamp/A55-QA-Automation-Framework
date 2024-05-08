package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "[type='submit']")
    private WebElement submitBtn;

    public void provideEmail(String email){
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        submitBtn.click();
    }
    public void loginMainPage() {
        provideEmail("charita.ramnathsing@testpro.io");
        providePassword("108KvbVhb2024");
        clickSubmit();
    }
}
