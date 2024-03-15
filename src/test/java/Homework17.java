import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongPlayList() throws InterruptedException {
        String namePlaylist= "Green Song";
        String expectedSongAddedSuccessMessage = "Added 1 song into \""+namePlaylist +".\"";
        String song = "Epic Songs";
       // navigateToPage();
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        Thread.sleep(2000);
        searchSong(song);
        Thread.sleep(2000);
        clickViewAllBtn();
        Thread.sleep(2000);
        selectFirstSong();
        Thread.sleep(2000);
        clickAddToBtn();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        Assert.assertEquals(getSongAddedSuccessMessage(),expectedSongAddedSuccessMessage);

    }
    public String getSongAddedSuccessMessage(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
       return notification.getText();

    }


    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Green Song')]"));
        playlist.click();
        Thread.sleep(5000);

        ////section[@id='songResultsWrapper']//li[contains(text(),'Green Song')]
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addToBtn.click();
    }

    public void selectFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();


    }

    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(song);



    }



}



