import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{
    public Actions action = new Actions(driver);
    @Test
    public void renameSmartPlaylist(){
        //Step1: login to the Koel website.
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();

        WebElement playlistSmart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]//a[contains(@href,'70585')]")));
        //Step2: Navigate to the chosen playlist using xpath //*[@id="playlists"]//a[contains(@href,'70585')]
        //Step3: Right click on the chosen playlist using actions
        action.contextClick(playlistSmart).perform();
        //Step4: Choose the edit option using locator [data-testid="playlist-context-menu-edit-70585"]
       editButtonClick();
        //Step5: Click on the name field using locator [name="name"]
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"name\"]")));
        nameField.click();
        //Step6: Clear the name field
        nameField.clear();
        //Step7: Enter the new name of the playlist
        nameField.sendKeys("New Smart");
        //Step8: Click on the Save button using xpath //div[@class="smart-playlist-form"]//footer/button[@type="submit"]
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"smart-playlist-form\"]//footer/button[@type=\"submit\"]")));
        saveButton.click();
        //Step9: Confirm Success message using notification xpath: //div[@class="alertify-logs top right"]/div[@class='success show']
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class='success show']")));
        String messageOfSuccess = "Updated playlist \"New Smart.\"";
        //Step10: messageExpected is Updated playlist "New Smart."
        Assert.assertEquals(successMessage.getText(),messageOfSuccess);
    }
    @Test
    public void renamePlaylist(){
        //Step1: login to the Koel website.
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();

        //Step2: Navigate to the chosen playlist using xpath
        WebElement chosenPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id =\"playlists\"]//a[contains(@href,87052)]")));
        //Step3: Right click on the chosen playlist using actions
        action.contextClick(chosenPlaylist).perform();
        //Step4: Choose the edit option using locator [data-testid="playlist-context-menu-edit-70585"]
        editButtonClick();
        //Step5: Clear the field
        chosenPlaylist.clear();
        //Step6: Enter the new name
        chosenPlaylist.sendKeys("New name");
        //Step7: Press the enter key
        action.sendKeys(Keys.RETURN);
        //Step8: Confirm we received the notification "Updated playlist \"New Playlist.\""
        String sucessMessage = "Updated playlist \"New name.\"";
        WebElement messageOfSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class='success show']")));
        Assert.assertEquals(messageOfSuccess.getText(),sucessMessage);

    }
}
