package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
By firstSongInSongsList = By.cssSelector(".all-songs tr.song-item:nth-child(1)");

    By playOption = By.xpath("//li[@class='playback']");
    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
       // findElement(firstSongInSongsList);
        actions.contextClick( firstSongElement).perform();
    }
    public void choosePlay() {
        findElement(playOption).click();
    }
}
