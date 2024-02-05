import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        selectPlaylist();
        Thread.sleep(2000);
        clickDeletePlaylistBtn();

        Thread.sleep(2000);
        String namePlaylist = "Oreo";
        String deletedPlaylistSuccessMessage = "Deleted Playlist \" " + namePlaylist +".\"";
        Assert.assertEquals(getPlaylistDeletedMessage(),deletedPlaylistSuccessMessage);


    }
    public String getPlaylistDeletedMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.hide"));
        return notification.getText();
    }



    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@title= 'Delete this playlist']"));
        deletePlaylistBtn.click();
    }

    public void selectPlaylist() {
        WebElement playlistName = driver.findElement(By.xpath("//a[contains(text(),'Oreo')]"));
        playlistName.click();
    }
}
