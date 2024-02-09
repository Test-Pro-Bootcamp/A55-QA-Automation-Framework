import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlayList() throws InterruptedException {
        String expectedSuccessUpdateMessage = "Updated playlist \"my_list..\"";
        //navigateToUrl();
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
        rightClickPlaylist();
        clickEdit();
        //clearTheField();
        enterNewName();
        Assert.assertEquals(getSuccessUpdatedPlayListMessage(), expectedSuccessUpdateMessage );
    }

    public void enterNewName() {
        WebElement NewName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='active']")));
        //NewName.clear();
        NewName.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        NewName.sendKeys("new_list");
        NewName.sendKeys(Keys.ENTER);
    }

    //public void clearTheField() {
    //WebElement InputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
    //InputField.clear();
    //}
    public void clickEdit() {
        WebElement EditBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-edit-89290']")));
        Actions action = new Actions(driver);
        action.contextClick(EditBtn).perform();
    }
    public void rightClickPlaylist() {
        WebElement PlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/89290']")));
        Actions action = new Actions(driver);
        action.contextClick(PlayList).perform();
    }
    public String getSuccessUpdatedPlayListMessage() throws InterruptedException {
        WebElement messagePopUP = driver.findElement(By.xpath("//div[@class='success show']"));
        Thread.sleep(2000);
        return messagePopUP.getText();
    }
}
