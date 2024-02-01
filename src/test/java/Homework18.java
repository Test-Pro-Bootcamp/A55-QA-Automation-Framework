import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playsong() throws InterruptedException {
        enterEmail();
        enterPassword();
        loginButton();
        playNextSongButton();
        playButton();
        pauseButtonIsDisplayed();
        playBarDisplayed();
    }

    public void playNextSongButton(){
        WebElement playNextSong = driver.findElement(By.cssSelector("[title=\"Play next song\"]"));
        playNextSong.click();
    }
    public void playButton(){
        WebElement playSong = driver.findElement(By.cssSelector("[title=\"Play or resume\"]"));
        playSong.click();
    }
    public void pauseButtonIsDisplayed(){
        WebElement pauseButton = driver.findElement(By.cssSelector("[title=\"Pause\"]"));
        boolean songPlaying = pauseButton.isDisplayed();
        Assert.assertTrue(songPlaying, "Song is not being played.");
    }
    public void playBarDisplayed(){
        WebElement playBarWhenSongIsPlaying = driver.findElement(By.xpath("//div[@id=\"progressPane\"]/h3[@class=\"title\"]"));
        Assert.assertTrue(playBarWhenSongIsPlaying.isDisplayed(), "Song is not playing.");
    }
}
