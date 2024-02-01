import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong(){
        //Step1: Open koel app and login
        navigateToPage();
        provideEmail("nicolai.luta@testpro.io");
        providePassword("tAPO0uuR");
        clickSubmit();
        // Step2: click 'Play' and 'Next' btn
        clickPlay();
        // Step3: check if the song is playing, by checking if 'sound bar icon' is moving.
        Assert.assertTrue(isSongPlaying());
    }
    public void  clickPlay() {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextBtn.click();
        playBtn.click();
    }
    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
//