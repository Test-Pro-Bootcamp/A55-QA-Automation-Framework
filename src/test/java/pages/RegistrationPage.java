package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    protected By registrationLink = By.cssSelector("[href='registration']");
    protected By registrationPageMessage = By.xpath("//div[@class='login-wrapper']/h2[contains(text(),'Register')]");
    //Registration Page message "Register new account or"
    public String registrationPageMsg = "Register new account or";

    protected By emailField = By.cssSelector("[type='email']");
    protected By submitBtn = By.cssSelector("[type='submit']");
    protected By successMsg = By.xpath("//form[@method=\"POST\"]/div[@class='messages']");

    public String successfulRegistrationMsg = "We've sent a confirmation link to the email. Please continue by clicking on it";

    public void clickOnRegistrationLink(){
        findElement(registrationLink).click();
    }

    public void confirmLandingOnRegPg(){
        String msg= findElement(registrationPageMessage).getText();
        Assert.assertTrue(msg.contains(registrationPageMsg));
    }

    public void enterEmail(){
        findElement(emailField).sendKeys("bfdkbqfkj@testpro.io");
    }

    public void clickSubmit(){
        findElement(submitBtn).click();
    }

    public void confirmSuccess(){
        String msg = findElement(successMsg).getText();
        Assert.assertTrue(msg.contains(successfulRegistrationMsg));
    }

}