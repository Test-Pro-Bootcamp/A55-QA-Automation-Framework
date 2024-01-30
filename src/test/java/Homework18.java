import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong(){
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickBtn();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        playNextSongBtn();
        clickPlayBtn();
        songIsPlaying();
    }

    private boolean songIsPlaying() {
        WebElement songBarDisplayed = driver.findElement(By.cssSelector("[data-testid=sound-bar-play]"));
        return songBarDisplayed.isDisplayed();
    }

    private void clickPlayBtn() {
        WebElement playBtn= driver.findElement(By.cssSelector("[data-testid=play-btn]"));
        playBtn.click();
    }

    private void playNextSongBtn() {
        WebElement nextSongBtn= driver.findElement(By.cssSelector("i[data-testid=play-next-btn]"));
        nextSongBtn.click();
    }

}
