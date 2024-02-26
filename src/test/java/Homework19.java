import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

  @Test
    public void deletePlaylist() {
      String expectedPlaylistDeletedMsg = "Deleted playlist \"test.\"";
      //Step1: navigate to koel and login
      navigateToPage();
      provideEmail("nicolai.luta@testpro.io");
      providePassword("tAPO0uuR");
      clickSubmit();
      //Step2: open playlist
      openPlaylist();
      //Step3: click delete btn
      clickDeleteBtn();

    //Step4: check if playlist is deleted
    Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMsg);
  }

  public void clickDeleteBtn() {
    WebElement deletePlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
    deletePlaylist.click();
  }

  public void openPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(5)"));
        playlist.click();
    }
    public String getDeletedPlaylistMsg(){
    WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
    return notificationMsg.getText();
    }
}
