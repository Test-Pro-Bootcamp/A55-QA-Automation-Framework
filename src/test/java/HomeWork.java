import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork extends BaseTest{

    @Test
    public void renameSmartPlaylist(){
        //Step1: login to the website.
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        avatarIsDisplayed();

        WebElement playlistSmart = driver.findElement(By.xpath("//*[@id=\"playlists\"]//a[contains(@href,'70585')]"));
        //Step2: Navigate to the chosen playlist using xpath //*[@id="playlists"]//a[contains(@href,'70585')]
        //Step3: Right click on the chosen playlist using actions and edit the name
        actions.moveToElement(playlistSmart).contextClick(playlistSmart).build().perform();
        editButtonClick();
        renameTheSmartPlaylist();
        //Step8: Click on the Save button using xpath //div[@class="smart-playlist-form"]//footer/button[@type="submit"]
        saveSmartPlaylist();
        //Step9: Confirm Success message using notification xpath: //div[@class="alertify-logs top right"]/div[@class='success show']
        successMessageSmartPlaylistIsDisplayed();
    }
    @Test
    public void renamePlaylist(){
        //Step1: login to the website.
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        //Step2: Navigate to the chosen playlist using xpath
        WebElement chosenPlaylist = driver.findElement(By.xpath("//section[@id='playlists']/ul//a[@href='#!/playlist/87052']"));
        wait.until(ExpectedConditions.visibilityOf(chosenPlaylist)).click();
        //Step3: Right-click on the chosen playlist using actions
        actions.moveToElement(chosenPlaylist).doubleClick(chosenPlaylist).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='text']")));
        //Step4: Choose the edit option using locator
        /*WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul/li[5]//li[1]")));
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        Thread.sleep(1000);*/
        //Step5: Clear the field
        WebElement playlistNewNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul/li[@class='playlist playlist editing']/input[@type='text']")));
        actions.moveToElement(chosenPlaylist).doubleClick(playlistNewNameField).sendKeys(Keys.BACK_SPACE);
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
