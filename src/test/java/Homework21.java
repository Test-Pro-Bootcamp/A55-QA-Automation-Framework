import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String newPlaylistName = "Test21";

    @Test

    public void renamePlaylist() {
        String updatedPlaylistSuccessMSG ="Updated playlist\"Test21.\"";
        //login
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();
        //doubleClickPlaylist
        doubleClickPlaylist();
        //newName
        enterNewName();

        //assertions
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistSuccessMSG);
    }

    public void enterNewName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        playListInputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'1b')]")));
        actions.doubleClick(playlistElement).perform();
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        return notification.getText();
    }
}