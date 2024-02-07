

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TrainingTest extends BaseTest {


    @Test
    public void hoverOverToPlayBtn() {
        login();
        chooseAllSongs();
        Assert.assertTrue(hoverOver().isDisplayed());
    }

    @Test
    public void contextClick() {
        login();
        chooseAllSongs();
        contextClickFirstSong();
        clickPlayBtn();
        Assert.assertTrue(soundBarVis());
    }

    @Test
    public void contextClickAndHover() {
        String AddedSongMsgSuccess = "Added 1 song into \"vivo.\"";
        login();
        chooseAllSongs();
        contextClickFirstSong();
        hoverOverToAddToBtn();
        clickPlaylistName();
        Assert.assertEquals(notificationMessage(), AddedSongMsgSuccess);
    }

    @Test
    public void countALlSongs() {
        login();
        choosePlaylistByName("vivo");
        displayAllSongs();
        Assert.assertTrue(playlistDetails().contains(String.valueOf(countSongs())));
    }

    public String playlistDetails() {
        return driver.findElement(By.xpath("//span[@class='meta text-secondary']//span[@class='meta']")).getText();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.xpath("//section[@id='playlistWrapper']//tr//td[@class='title']"));
        System.out.println("number of songs found is :  " + countSongs());
        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public int countSongs() {
        return driver.findElements(By.xpath("//section[@id='playlistWrapper']//tr//td[@class='title']")).size();
    }

    private void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public String notificationMessage() {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return successMsg.getText();
    }

    private void clickPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='has-sub']//ul//li[contains(text(),'vivo')]"))).click();
    }

    private WebElement hoverOverToAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("[class='has-sub']"));
        actions.moveToElement(addToBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(addToBtn));
    }

    public boolean soundBarVis() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
    }

    private void clickPlayBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='playback']"))).click();
    }

    private void contextClickFirstSong() {
        WebElement contextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songsWrapper']//tr//td[contains(text(),'M33 Project - Emotional Soundtrack')]")));
        actions.contextClick(contextBtn).perform();
    }

    public WebElement hoverOver() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
    }

    public void chooseAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='songs']"))).click();
    }
}

