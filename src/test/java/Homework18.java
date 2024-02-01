import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        logintoKoel();
        Thread.sleep(2000);
        //click to play
        clickPlay();
        //Assertion
        Assert.assertTrue(isSongPlaying());
    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    public void clickPlay() {
        WebElement playNextBtn = driver.findElement(By.xpath("i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[data-testid='play-btn']"));
        playNextBtn.click();
        playBtn.click();
    }
}
