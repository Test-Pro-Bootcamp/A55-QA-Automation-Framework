import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {

        //NavigateToPage
      //  navigateToPage();
        //Login with correct credentials
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        Thread.sleep(2000);
        //Click on Avatar
        clickOnAvatarIcon();
        //Generate Random Name
        String randomName = generateRandomName();
        //Provide current password
        provideCurrentPassword("te$t$tudent");
        //Set the new username
        provideProfileName(randomName);
        Thread.sleep(2000);
        //Click on Save
        clickSave();
        Thread.sleep(2000);
        //Assertion (expected VS actual result)
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(),randomName);
    }



    public void clickSave() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String newName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public void provideCurrentPassword(String Password) {
        WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(Password);

    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("_", "");

    }

    public void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();


    }


}
