import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {

        //navigate
        //navigateToPage();
        //login valid credantials
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();

        // click Play next song
        clickPlayNextSong();
        Thread.sleep(2000);
        // play button
        clickPlayButton();
        Thread.sleep(5000);
        // assertions

        boolean soundBarIsDisplayed;
        Assert.assertTrue(soundBarIsDisplayed());
        Thread.sleep(10000);
    }
    public boolean soundBarIsDisplayed() throws InterruptedException {
        WebElement soundBarField = driver.findElement(By.cssSelector("div.plyr__controls"));
        return soundBarField.isDisplayed();
    }
  public void clickPlayButton() throws InterruptedException {
        WebElement  playButton = driver.findElement(By.xpath("//*[@id='mainFooter']//span[@class='play']"));
      Thread.sleep(10000);
    }


    public void clickPlayNextSong() {
        WebElement playNextSongField = driver.findElement(By.xpath("//*[@id='mainFooter']//i[@title='Play next song']"));
        playNextSongField.click();

    }

}
