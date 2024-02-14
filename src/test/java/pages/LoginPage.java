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

    //private By emailField = By.cssSelector("input[type='email']");
    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    //private By passwordField = By.cssSelector("input[type='password']");
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    //private  By loginBtn = By.cssSelector("button[type='submit']");
    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;


    //Helper Methods

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElement(loginBtn).click();
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void login(String baseURL, String email, String password){
        navigateToPage(baseURL);
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
}
