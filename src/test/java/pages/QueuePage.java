package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class QueuePage extends BasePage {
    public QueuePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(xpath = "//*[text()='shuffling all songs']")
    public WebElement queueShuffleAllSongs;

    @FindBy(xpath = "//*[text()='No songs queued.']")
    private WebElement noSongsQueued;

    @FindBy(css = "span.secondary.d-block")
    private WebElement noSongsSecondaryBlock;

    @FindBy(xpath = "//section[@id='queueWrapper']//div[@class='heading-wrapper']//span[@data-test='list-meta']")
    private WebElement songsAndDuration;
    @FindBy(xpath = "//section[@id='queueWrapper']//button//*[@class='fa fa-random']")
    private WebElement accessShuffleBtnCurrentQ;
    // driver.findElement(By.cssSelector("a[href='/favourites']"));

    @FindBy(xpath = "//section[@id='playlistWrapper']//button[@class='btn-shuffle-all']")
    private WebElement accessShuffleBtnPlaylistQ;
    @FindBy(xpath = "//section[@id='songsWrapper']//button[@class='btn-shuffle-all']")
    private WebElement accessShuffleBtnAllSongsQ;
    @FindBy(xpath = "//section[@id='recentlyPlayedWrapper']//div[@class='song-list-controls']")
    private WebElement accessShuffleBtnRecentPlaylistQ;

    @FindBy(xpath = "//section[@id='playlists']//li[3]")
    private WebElement accessPlaylists;

    @FindBy(xpath = "//section[@class='music']//a[@class='songs']")
    private WebElement allSongs;
    @FindBy(css = "button.btn-shuffle-all")
    private WebElement shuffleAllBtn;
    @FindBy(css="li.playlist.recently-played")
    private WebElement recentlyPlayed;
    @FindBy(xpath = "//section[@id='playlists']//*[text()[contains(., 'Homelist')]]")
    private WebElement getAccessShuffleBtnPlaylist;
    @FindBy(css="button.btn-clear-queue")
    private WebElement clearQueueBtn;

    public void clickShuffleAllSongs() {

        queueShuffleAllSongs.click();
    }

    public void checkTotalSongsAndDuration() {
        String text = songsAndDuration.getText();
        Assert.assertEquals(text, "66 songs • 04:32:57");

    }
    public void listOfAllHeaders() {
        List<String> headers = Arrays.asList("#", "title", "artist", "album", "time");

        List<WebElement> anchors = driver
                .findElements(By.xpath("//table[@class='song-list-header unsortable']//thead//tr//th"));
        int count = 0;
            for (WebElement ele : anchors) {
                //System.out.println(ele.getAttribute("innerHTML"));
                System.out.println(ele.getAttribute("innerText"));
                System.out.println(ele.getAttribute("innerText").toLowerCase().contains(headers.get(count)));
                System.out.println(count);
                count = count + 1;
                if (count > headers.size()-1){
                    break;
                }
            }
    }

    public void currentQueue() {
        // User should be navigated to the Current Queue page after double clicking on the song on the following pages:
        // Home, All songs, Albums, Artists, Favorites, Recently played and Homelist (user's created playlist)
        accessShuffleBtnCurrentQ.click();
        System.out.println("All songs");
        String text = accessPlaylists.getText();
        Assert.assertEquals(text,"Homelist");
        System.out.println("Home");
        accessPlaylists.click();
        accessShuffleBtnPlaylistQ.click();
        recentlyPlayed.click();
        System.out.println("Recently played");
        accessShuffleBtnRecentPlaylistQ.click();
        allSongs.click();
        accessShuffleBtnAllSongsQ.click();
        System.out.println("all songs");

    }

    public void shuffleAll() {
        // 'Shuffle All' button should shuffle songs
        shuffleAllBtn.click();
    }

    public void clearSongsQueue() {
        // The page should be empty after clicking on 'Clear' button. 'No songs queued. How about shuffling all songs?' message should appear.
        //Songs should appear on the Current Queue page  when clicking on the 'shuffling all songs'
        clearQueueBtn.click();
        String textClear = noSongsSecondaryBlock.getText();
        Assert.assertEquals(textClear,"How about shuffling all songs?");
        System.out.println("Clear Queue");


    }
}
