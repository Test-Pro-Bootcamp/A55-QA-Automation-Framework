package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PauseSongPage extends BasePage{

    //WebElements

    protected By firstSong = By.xpath("//section[@id='songsWrapper']//div//tr[1]/td[2]");
    protected By pauseBtn = By.xpath("//footer//span[@class=\"pause\"]/i[@class=\"fa fa-pause\"]");
    protected By hoverLocation = By.cssSelector("[class=\"album-thumb-wrapper\"]");

    public PauseSongPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public void doubleClickFirstSongAndPlay(){
        findElement(firstSong).click();
        WebElement song = findElement(firstSong);
        actions.doubleClick(song).build().perform();
    }

    public void pauseSong(){
        WebElement hoverPausePlay = findElement(hoverLocation);
        actions.moveToElement(hoverPausePlay).build().perform();
        WebElement pauseButton = findElement(pauseBtn);
        actions.moveToElement(pauseButton).build().perform();
        pauseButton.click();
        String stateOfPlayPauseBtn = pauseButton.getAttribute("class");
        Assert.assertTrue(stateOfPlayPauseBtn.contains("play"), "the song is not paused");
    }
}
