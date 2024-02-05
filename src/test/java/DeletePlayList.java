import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeletePlayList extends  BaseTest{
  //  Navigate to "https://qa.koel.app/".
  // Log in with your credentials.

  @BeforeMethod
  @Parameters({"BaseURL", "Email", "Password"})
  public void start(String baseURL, String email, String password) {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    loginValidEmailPassword(baseURL, email, password);
  }


  private void loginValidEmailPassword(String baseURL, String email, String password) {
    //Steps 1: Open Browser and navigate to Koel app.
    navigateToPage(baseURL);
    //Step 2: Enter email
    provideEmail(email);
    //Step 3: Enter Password
    providePassword(password);
    //Step 4: Click on Login button
    loginToKoel();
    //Assertion (expected vs actual)
    WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
    Assert.assertTrue(avatarIcon.isDisplayed());
  }

  @Test
  public void deletePlayList() throws InterruptedException {
      String playlist = "my musik";

      clickPlusButton();
      chooseNewPlaylist();
      enterPlaylistName(playlist);
      Thread.sleep(500);

      String createdMsg = "Created playlist \""+playlist+".\"";
      Assert.assertEquals(playlistCreated(), createdMsg);
      Thread.sleep(5000);

      //Click the playlist you want to delete.
      clickPlaylist();

      // We should see a red button "x PLAYLIST" on the top right part of the page, and click on it.
      deleteButton();
      Thread.sleep(500);

      //  Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
      String message = "Deleted playlist \""+playlist+".\"";
      Assert.assertEquals(getDeleteMessage(), message);
  }

  public void clickPlaylist() {
    WebElement playlistBtn =  driver.findElement(By.xpath("//section[@id='playlists']//a[text()='my musik']"));
    playlistBtn.click();

  }
 public void deleteButton() {
   WebElement deleteBtn =  driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
    deleteBtn.click();
 }

 public String getDeleteMessage() {
   WebElement msg = driver.findElement(By.cssSelector("div.success.show"));
   return msg.getText();
 }

  public String playlistCreated() {
    WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
    return notificationMsg.getText();
  }

    public void enterPlaylistName(String newPlaylistName) {
    WebElement playlistNameField = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
    playlistNameField.clear();
    playlistNameField.sendKeys(newPlaylistName);
    playlistNameField.sendKeys(Keys.ENTER);
  }

    public void chooseNewPlaylist() {
    WebElement newPlaylist = driver.findElement(By.cssSelector("#playlists > nav > ul > li:nth-child(1)"));
    newPlaylist.click();
  }

  public void clickPlusButton() throws InterruptedException {
    WebElement btn = driver.findElement(By.cssSelector("#playlists > h1 > i"));
    Actions s = new Actions(driver);
    s.moveToElement(btn).build().perform();
    Thread.sleep(500);
    s.click(btn).build().perform();
  }


}
