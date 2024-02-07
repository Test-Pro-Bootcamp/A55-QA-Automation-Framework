import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        Assert.assertTrue(successDeletedPlayListMessage());
    }

    private void clickPlaylist() throws InterruptedException {
        WebElement PlayListName = driver.findElement(By.cssSelector("a[href='#!/playlist/88224]"));
        PlayListName.click();
        Thread.sleep(2000);
    }
    private void clickRedCross() {
        WebElement RedButton = driver.findElement(By.cssSelector("button[title = 'Delete this playlist']"));
        RedButton.click();
    }
    public boolean successDeletedPlayListMessage() throws InterruptedException {
        WebElement DeletedPlayListPopUp = driver.findElement(By.cssSelector("div[class= 'success show']"));
        Thread.sleep(2000);
        return(DeletedPlayListPopUp.isDisplayed());

    }

}
