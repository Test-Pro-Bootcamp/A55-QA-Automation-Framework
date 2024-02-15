import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

@Test

public class ProfileTest extends BaseTest{
    public String changeProfileName() throws InterruptedException {
        //Task:need to change the username

        //Navigation to page
        //navigateToPage();
        //Login with correct credentials
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        logintoKoel();
        Thread.sleep(2000);
        //Click on avatar
        clickAvatarIcon();
        //Generate random username
        String randomName=generateRandomName();
        System.out.println("Random name is: "+ randomName);
        //Provide current password
        provideCurrentPassword("te$t$tudent");
        //Set new profile name
        provideProfileName(randomName);
        Thread.sleep(2000);
        //Click on save
        clickSave();
        Thread.sleep(5000);
        //Assertion (Expected vs Actual results)
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile.span"));
        System.out.println(actualProfileName.getText());
        Assert.assertEquals(actualProfileName.getText(), randomName());


    }



    public void provideProfileName(String newName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public String randomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String current_password) {
        WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys();
    }

    public void clickSave() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }




}


