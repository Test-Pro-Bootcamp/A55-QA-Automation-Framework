import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlayList()  {
        //GIVEN
        //navigateToUrl();
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
        //when
        clickPlaylist();
        clickRedCross();
        String expectedDeletedPlayListMessage = "Deleted playlist \"my_list.\"";
        Assert.assertEquals(getSuccessDeletedPlayListMessage(),expectedDeletedPlayListMessage );
    }

    private void clickPlaylist()  {
        //WebElement PlayListName = driver.findElement(By.cssSelector("a[href='#!/playlist/88398']"));
        //here we are using explicit wait with its syntax
        WebElement PlayListName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/88691']")));
        Actions action = new Actions(driver);
        action.contextClick(PlayListName).perform();
    }
    private void clickRedCross(){
        //WebElement RedButton = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        WebElement RedDeleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Delete this playlist']")));
        RedDeleteBtn.click();
    }
    public String getSuccessDeletedPlayListMessage(){
        //WebElement DeletedPlayListPopUp = driver.findElement(By.cssSelector("div[class= 'success show']"));
        WebElement RedDeleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class= 'success show']")));
        return RedDeleteBtn.getText();

    }

}



