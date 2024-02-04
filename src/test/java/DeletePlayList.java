import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    driver.manage().window().maximize();


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
  public void deletePlayList() {
    // Click the playlist you want to delete.
    clickPlaylist();
    // We should see a red button "x PLAYLIST" on the top right part of the page, and click on it.
    deleteButton();

    //  Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
    String message = "Deleted playlist \"my musik.\"";
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

}
