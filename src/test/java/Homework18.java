import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

public class Homework18 extends BaseTest {
    @Test
    public void playSong (){
        navigateToUrl();
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
        clickPlayNextSong();
        clickPlay();
        Assert.assertTrue(SoundBarIsDisplayed());
    }

    public boolean SoundBarIsDisplayed() {
        WebElement SoundBar = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        return(SoundBar.isDisplayed());

    }

    public void clickPlay() {
        WebElement PlaySong = driver.findElement(By.cssSelector("i[class='fa fa-play']"));
        PlaySong.click();
    }

    public void clickPlayNextSong() {
        WebElement NextSongBtn = driver. findElement(By.cssSelector("i[title='Play next song']"));
        NextSongBtn.click();
    }



}
