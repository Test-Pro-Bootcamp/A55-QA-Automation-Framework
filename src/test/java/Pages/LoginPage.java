package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * this class is using Selenium By abstract class to locate elements
 * login helper methods are using the By class for locators
 */




public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);

    }

    //Web Elements

    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By loginBtn = By.cssSelector("button[type='submit']");

}

//Helper Methods

/*
public void provideEmail(String email){
    findElement(emailField).sendkeys(email);
    }

public void providePassword(String password){
    findElement(passwordField).sendkeys(password);
}
public void clickSubmit() {
    findElement(loginBtn).click();
    }

 */


public void login() {
    provideEmail("demo@class.com");
    providePassword("te$t$tudent");
    clickSubmit();
}





        /*
        @Test

        public void deletePlaylist() {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.provideEmail("demo@class.com");
            loginPage.providePassword("te$t$tudent");
            loginPage.clickSubmit();
            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
            }
            */


}

