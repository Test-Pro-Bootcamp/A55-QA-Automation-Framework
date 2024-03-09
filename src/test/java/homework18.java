import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {
        // login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        Thread.sleep(2000);
        // click on play button
        clickPlay();
        Thread.sleep(2000);
        // Assertion
        Assert.assertTrue(isSongPlaying());
    }

    private boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    private void clickPlay() {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextBtn.click();
        playBtn.click();
    }
}
