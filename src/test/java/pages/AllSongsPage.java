package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllSongsPage extends BasePage{


    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    //Web Elements

    @FindBy (css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement firstSongInAllSongs;
    @FindBy (css = "li.playback")
    private WebElement playBtnInContextMenu;
    @FindBy (xpath = "//i[@data-testid='play-next-btn']")
    private WebElement nextBtn;
    @FindBy (xpath = "//span[@data-testid='play-btn']")
    private WebElement playBtn;


    //Helper Methods

    public AllSongsPage contextClickFirstSong(){
        actions.contextClick(firstSongInAllSongs).perform();
        return this;
    }
    public AllSongsPage choosePlayOption(){
        playBtnInContextMenu.click();
        return this;
    }

    public AllSongsPage clickPlay(){
        nextBtn.click();
        playBtn.click();
        return this;
    }

}
