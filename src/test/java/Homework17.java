//import org.openqa.selenium.chrome.ChromeDriver;//
//import org.openqa.selenium.chrome.ChromeOptions;//
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;//
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void AddSongToPlaylist() throws InterruptedException {
        //navigate to page
        navigateToUrl();
        //login with to koel.app
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();

        EnterSongToSearchBar();
        clickViewAll();
        ClickSong();
        ClickAddTo();





    }

    @Test
    public void EnterSongToSearchBar() throws InterruptedException {
            WebElement SearchField = driver.findElement(By.cssSelector("input[type='search']"));
            SearchField.clear();
            Thread.sleep(2000);
            SearchField.sendKeys("Dark Days");
            SearchField.click();
            Thread.sleep(2000);

    }
    @Test
    public void clickViewAll() throws InterruptedException {
        WebElement ViewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        ViewAllBtn.click();
        Thread.sleep(2000);
        }

    @Test
    public void ClickSong() throws InterruptedException {
        WebElement FirstSong = driver.findElement(By.xpath("//td[contains(text(),'Dark Days')]"));
        Actions action = new Actions(driver);
        action.contextClick(FirstSong).perform();
        Thread.sleep(2000);
    }

    @Test
    public void ClickAddTo(){
        WebElement AddTo = driver.findElement(By.cssSelector("li[class='has-sub']"));
    }

    @Test
    public void ClickPlaylistName() throws InterruptedException {
        WebElement PlayListName = driver.findElement(By.cssSelector("a[href='#!/playlist/86987']"));
        PlayListName.click();
        Thread.sleep(2000);
    }


}
























