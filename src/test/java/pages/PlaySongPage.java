package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaySongPage extends BasePage{

    public PlaySongPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //WebElements

    protected By firstSong = By.xpath("//section[@id='songsWrapper']//div//tr[1]/td[2]");
    protected By playBtn = By.cssSelector("[class=\"playback\"]");


    public void contextClickFirstSongAndPlay(){
        findElement(firstSong).click();
        WebElement song = findElement(firstSong);
        actions.contextClick(song).build().perform();
        findElement(playBtn).click();
    }
}
