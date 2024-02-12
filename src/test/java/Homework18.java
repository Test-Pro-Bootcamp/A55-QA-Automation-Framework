import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {


        navigateToPage("https://qa.koel.app/");
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA55");
        loginToKoel();
        Thread.sleep(5000);
        playNextSongBtn();
        playSongBtn();
        Thread.sleep(5000);

        Assert.assertTrue(isSongPlaying());

    }
    public void playSongBtn() {
        WebElement playBtn = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        playBtn.click();
    }
    public void playNextSongBtn(){
        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextSong.click();
    }

    public boolean isSongPlaying(){
        WebElement soundBar = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        return soundBar.isDisplayed();

    }
}
