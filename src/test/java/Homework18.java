import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        navigateToPage();
        loginToKoel();
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        Thread.sleep(2000);
        clickPlay();
        Thread.sleep(2000);
        Assert.assertTrue(isSongPlaying());


    }

    public void clickPlay() {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextBtn.click();
        playBtn.click();
    }
    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return  soundBar.isDisplayed();
    }


}
