package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{
    @FindBy(css = "[data-testid='btn-logout']")
    private WebElement logoutButton1;
    @FindBy(css = "[type='email']")
    private WebElement newEmailField;
    @FindBy(css = "[name='new_password']")
    private WebElement newPasswordField;
    @FindBy(css = "[name='current_password']")
    private WebElement currentPasswordField;
    @FindBy(css = "[type='submit']")
    private WebElement saveBtn;
    @FindBy(css = "div.success.show")
    private WebElement updateMsg;
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public ProfilePage addNewEmail(String newEmail){
        wait.until(ExpectedConditions.visibilityOf(newEmailField)).click();
        findElement(newEmailField).sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        findElement(newEmailField).sendKeys(newEmail);
        findElement(newEmailField).sendKeys(Keys.ENTER);
        return this;
    }
    public ProfilePage clickSaveBtn(){
        wait.until(ExpectedConditions.visibilityOf(saveBtn)).click();
        return this;
    }
    public String emailHasUpdated(){
        wait.until(ExpectedConditions.visibilityOf(updateMsg));
        return updateMsg.getText();
    }
    public String passwordHasBeenUpdated(){
        wait.until(ExpectedConditions.visibilityOf(updateMsg));
        return updateMsg.getText();
    }
    public ProfilePage addNewPassword(String newPassword){
        wait.until(ExpectedConditions.visibilityOf(newPasswordField)).click();
        findElement(newPasswordField).sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        findElement(newPasswordField).sendKeys(newPassword);
        findElement(newPasswordField).sendKeys(Keys.ENTER);
        return this;
    }
    public ProfilePage addCurrentPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(currentPasswordField)).click();
        currentPasswordField.sendKeys(password);
        return this;
    }
    public ProfilePage clickLogOut1(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton1));
        logoutButton1.click();
        return this;
    }

}
