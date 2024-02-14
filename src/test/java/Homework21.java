import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    String NewPlaylistName = "myList";
    @Test
    public void renamePlayList()  {
        String expectedSuccessUpdateMessage = "Updated playlist \"myList..\"";
        //navigateToUrl();
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
        doubleClickPlaylist();
        enterNewName();
        //clearTheField();
        Assert.assertEquals(getSuccessUpdatedPlayListMessage(), expectedSuccessUpdateMessage );
    }
    public void enterNewName()  {
        WebElement NewName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //clear does not work, element has an attribute of 'required'
        //workaround is ctrl A(to select all) then backspace to clear then replace with
        // with new playlist mame

        //NewName.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        //NewName.sendKeys(Keys.BACK_SPACE);
        NewName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        NewName.sendKeys("myList");
        NewName.sendKeys(Keys.ENTER);
    }

    //public void clearTheField() {
    //WebElement InputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
    //InputField.clear();
    //}

    public void doubleClickPlaylist() {
        WebElement PlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/90824']")));
        Actions action = new Actions(driver);
        action.doubleClick(PlayList).perform();
    }
    public String getSuccessUpdatedPlayListMessage()  {
        WebElement messagePopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div[class='success.show']")));
        return messagePopUP.getText();
    }
}
