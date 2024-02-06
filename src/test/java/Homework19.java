import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistSuccessMessage = "Deleted playlist \"Oreo.\"";
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        selectPlaylist();
        Thread.sleep(2000);
        clickDeletePlaylistBtn();
        Thread.sleep(2000);
        Assert.assertEquals(getPlaylistDeletedMessage(),deletedPlaylistSuccessMessage);


    }
    public String getPlaylistDeletedMessage(){
       // WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }



    public void clickDeletePlaylistBtn() {
       // WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@title= 'Delete this playlist']"));
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title= 'Delete this playlist']")));
        deletePlaylistBtn.click();
    }

    public void selectPlaylist() {
        //WebElement playlistName = driver.findElement(By.xpath("//a[contains(text(),'Oreo')]"));/
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Oreo')]")));
        playlistName.click();
    }
}
