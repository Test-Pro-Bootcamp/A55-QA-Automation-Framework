package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    //WebElement
        private By avatar = By.cssSelector("[class=\"avatar\"]");
        private By koelsym = By.cssSelector("[class=\"logo\"]");

        public void provideEmail(String email){
            findElement(emailField).sendKeys(email);
        }
        public void providePassword(String password){
            findElement(passwordField).sendKeys(password);
        }
        public void clickLogin(){
            findElement(submitBtn).click();
        }
        public WebElement avatarFound(){
            return findElement(avatar);
        }

        public WebElement koelLogo(){
            return findElement(koelsym);
        }
}
