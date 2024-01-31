import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import  org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public  void playSong() throws InterruptedException{

        navigateToPage();
        provideEmail("ana.nicora@testpro.io");
        providePassword("QaKoelApp_1234");
        clickSubmit();
        Thread.sleep(2000);

        // Click «Play next song»(media player controls)
        clickPlayNextSong();

        // Play button, to play a song
        clickPlaySong();

       // Validate that a song is playing by verifying if the sound bar, or the pause button is displayed.
        Assert.assertEquals(isPauseButtonEnabled(), true);

    }

    public void clickPlayNextSong() {
        WebElement submit = driver.findElement(By.xpath("//i[@role='button' and @data-testid='play-next-btn']"));
        submit.click();
    }

    public void clickPlaySong() {
        WebElement submit = driver.findElement(By.xpath("//span[@role='button' and @data-testid='play-btn']/i"));
        submit.click();
    }
    public boolean isPauseButtonEnabled() {
        WebElement submit = driver.findElement(By.xpath("//span[@role='button' and @data-testid='pause-btn']/i"));
        return submit != null;
    }

}

