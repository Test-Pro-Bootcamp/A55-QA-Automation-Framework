import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;
public class HomeWork20 extends BaseTest{
    @Test
    public void deletePlayList() {
        String expectedPlayListMsg = "Deleted playlist \"Test1.\"";

        provideEmail("charita.ramnathsing@testpro.io");
        providePassword("108KvbVhb2024");
        loginToKoel();
        selectPlayList();
        clickDeletePlayList();

        System.out.println(getAlertMsg());
        submitAlertToDeletePlaylist();

        Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlayListMsg);
    }

    public String getAlertMsg() {

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        return notification.getText();
    }

    public void submitAlertToDeletePlaylist() {
        WebElement submitAlert = driver.findElement(By.cssSelector("button.ok"));
        submitAlert.click();
    }

    public void clickDeletePlayList() {
        WebElement playListElement = driver.findElement(By.xpath("//section[@id='playlistWrapper']//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']"));
        playListElement.click();

    }

    public void selectPlayList(){
        WebElement selectPlayListElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        selectPlayListElement.click();
    }

    public String getDeletedPlaylistMsg(){
        WebElement playlistMsg = driver.findElement(By.cssSelector("div.success.show"));
        return playlistMsg.getText();
    }


}
