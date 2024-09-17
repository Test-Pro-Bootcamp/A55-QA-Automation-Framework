import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedSongAddedSuccessMsg = "Deleted playlist \"HW19.\"";
        //navigate

        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        //log in
        clickSubmit();
        // click on the playlist
        clickOnPlaylist();

        // click to delete the playlist
        clickToDeletePlaylist();
        //Thread.sleep(2000);
        //Assertions
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedSongAddedSuccessMsg );

        //Thread.sleep(2000);
    }

    public void clickToDeletePlaylist() {
              //Implicit Wait
        // WebElement deletePlaylist = driver.findElement(By.xpath("//div/span/button[ @title= 'Delete this playlist']"));
             //Explicit Wait
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span/button[ @title= 'Delete this playlist']")));
        deletePlaylist.click();
    }

    public void clickOnPlaylist() {
       // WebElement clickPlaylist = driver.findElement(By.xpath("//li[ @class='playlist playlist']/a"));
        WebElement clickPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[ @class='playlist playlist']/a")));
        clickPlaylist.click();
    }

    public String getDeletedPlaylistMsg() {
       // WebElement notification = driver.findElement(By.xpath("//div[ @class='success show']"));
        WebElement notification =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[ @class='success show']")));
        return notification.getText();

    }
}