import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class Homework18 extends BaseTest {
    @Test
    public void playSong () throws InterruptedException {
        //GIVEN

        //navigateToUrl();
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
        //WHEN
        clickPlayNextSong();
        clickPlay();
        //THEN
        Assert.assertTrue(SoundBarIsDisplayed());
    }

    public boolean SoundBarIsDisplayed() throws InterruptedException {
        WebElement SoundBar = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        Thread.sleep(9000);
        return(SoundBar.isDisplayed());


    }
    public void clickPlay() throws InterruptedException {
        WebElement PlaySong = driver.findElement(By.xpath("//span[@class='play'] "));
        PlaySong.click();
        Thread.sleep(9000);
    }
    public void clickPlayNextSong() throws InterruptedException {
        WebElement NextSongBtn = driver. findElement(By.xpath("//i[@class='next fa fa-step-forward control'] "));
        NextSongBtn.click();
        Thread.sleep(9000);
    }
}
