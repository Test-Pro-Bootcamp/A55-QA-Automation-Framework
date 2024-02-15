import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homeWork extends BaseTest{

    @Test
    public void renameSmartPlaylist() throws InterruptedException {
        //Step1: login to the website.
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        Thread.sleep(2000);
        Actions action = new Actions(driver);

        WebElement playlistSmart = driver.findElement(By.xpath("//*[@id=\"playlists\"]//a[contains(@href,'70585')]"));
        //Step2: Navigate to the chosen playlist using xpath //*[@id="playlists"]//a[contains(@href,'70585')]
        //Step3: Right click on the chosen playlist using actions
        action.moveToElement(playlistSmart).contextClick(playlistSmart).build().perform();
        Thread.sleep(1500);
        //Step4: Choose the edit option using locator [data-testid="playlist-context-menu-edit-70585"]
        WebElement editButton = driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]/nav[@class='menu playlist-item-menu']/ul/li[1]"));
        editButton.click();
        Thread.sleep(2000);
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
        //Step10: messageExpected is Updated playlist "New Smart."
        Assert.assertEquals(successMessage.getText(),"Updated playlist \"New Smart.\"" );
    }
    @Test
    public void renamePlaylist() throws InterruptedException {
        //Step1: login to the website.
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        Actions action = new Actions(driver);
        //Step2: Navigate to the chosen playlist using xpath
        WebElement chosenPlaylist = driver.findElement(By.xpath("//section[@id='playlists']/ul//a[@href='#!/playlist/87052']"));
        wait.until(ExpectedConditions.visibilityOf(chosenPlaylist)).click();
        //Step3: Right-click on the chosen playlist using actions
        action.moveToElement(chosenPlaylist).doubleClick(chosenPlaylist).build().perform();
        Thread.sleep(2000);
        //Step4: Choose the edit option using locator
        /*WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul/li[5]//li[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        Thread.sleep(1000);*/
        //Step5: Clear the field
        WebElement playlistNewNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul/li[@class='playlist playlist editing']/input[@type='text']")));
        action.moveToElement(chosenPlaylist).doubleClick(playlistNewNameField).sendKeys(Keys.BACK_SPACE);
        playlistNewNameField.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
        //Step6: Enter the new name
        playlistNewNameField.sendKeys("New name");
        //Step7: Press the enter key
        playlistNewNameField.sendKeys(Keys.RETURN);
        //Step8: Confirm we received the notification "Updated playlist \"New Playlist.\""
        String successMessage = "Updated playlist \"New name.\"";
        WebElement messageOfSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class='success show']")));
        Assert.assertEquals(messageOfSuccess.getText(),successMessage);

    }

}
