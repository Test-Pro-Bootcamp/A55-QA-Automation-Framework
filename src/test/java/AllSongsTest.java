import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest {
    @Test

  public void playSong(){
        //Login
      LoginPage loginPage =  new LoginPage(driver);
      HomePage homePage = new HomePage(driver);
      AllSongsPage allSongsPage = new AllSongsPage(driver);

      loginPage.login();
      //loginPage.loginToKoelApp();
        homePage.chooseAllSongsList();
      allSongsPage.contextClickFirstSong();
      allSongsPage.choosePlay();
      Assert.assertTrue(allSongsPage.isSongPlaying());

  }
  //Old Code
    //public boolean isSongPlaying() {
       // WebElement soundBarVisualizer = wait.until(ExpectedConditions
           //     .visibilityOfElementLocated(By.xpath("//div//img[@alt='Sound bars']")));
        //return soundBarVisualizer.isDisplayed();
   // }

  //public void choosePlay() {
        //wait.until(ExpectedConditions
              //  .visibilityOfElementLocated(By.xpath("//li[@class='playback']"))).click();
   // }

    //public void contextClickFirstSong() {
       // WebElement firstSongElement = wait.until(ExpectedConditions
                //.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        //actions.contextClick(firstSongElement).perform();
   // }



}
