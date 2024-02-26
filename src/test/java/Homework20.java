import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class Homework20 extends BaseTest{

  @Test // Delete a playlist and verify the success message
  public void deletePlaylist() {
    String expectedPlaylistDeletedMsg = "Deleted playlist \"abc.\"";
    //Step1: navigate to koel and login

    provideEmail("nicolai.luta@testpro.io");
    providePassword("tAPO0uuR");
    clickSubmit();

    //Step2: open playlist
    openPlaylist();

    //Step3: click delete btn
    clickDeleteBtn();


    //Step4: check if playlist is deleted
    Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMsg,"The playlist deletion message does not match the expected one");
  }

  public void clickDeleteBtn() {
    //WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
    WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
    deletePlaylist.click();
  }

  public void openPlaylist() {
    //WebElement playlist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(5)"));
    WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3)")));
    playlist.click();
  }
  public String getDeletedPlaylistMsg(){
    //WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
    WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
    return notificationMsg.getText();
  }
}





