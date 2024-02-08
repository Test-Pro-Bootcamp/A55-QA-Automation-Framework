import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlayList() throws InterruptedException {
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


    private void clickPlaylist() throws InterruptedException {
        WebElement PlayListName = driver.findElement(By.cssSelector("a[href='#!/playlist/88398']"));
        Thread.sleep(11000);
        Actions action = new Actions(driver);
        action.contextClick(PlayListName).perform();
        Thread.sleep(7000);
    }
    private void clickRedCross() throws InterruptedException {
        WebElement RedButton = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        Thread.sleep(4000);
        RedButton.click();
        Thread.sleep(3000);
    }
    public String getSuccessDeletedPlayListMessage() throws InterruptedException {
        WebElement DeletedPlayListPopUp = driver.findElement(By.cssSelector("div[class= 'success show']"));
        Thread.sleep(2000);
        return DeletedPlayListPopUp.getText();

    }

}
