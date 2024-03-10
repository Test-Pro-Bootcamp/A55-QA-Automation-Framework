import org.openqa.selenium.*;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.cssSelector;

public class HomeWork21 extends BaseTest{
    @Test
    public void renamePlaylist() {
        String expectedPlayListMsg = "Updated playlist \"Test2.\"";
        provideEmail("charita.ramnathsing@testpro.io");
        providePassword("108KvbVhb2024");
        loginToKoel();

        selectPlayList();

        Assert.assertEquals(getUpdatedPlaylistMsg(), expectedPlayListMsg);

    }

    public String getUpdatedPlaylistMsg() {
        WebElement playListMsg = driver.findElement(cssSelector("div.success.show"));
        return playListMsg.getText();
    }

    public void selectPlayList() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectPlayListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));

        Actions action = new Actions(driver);
        action.doubleClick(selectPlayListElement).perform();
        action.doubleClick(selectPlayListElement).perform();

        action.sendKeys("Test2").perform();
        action.sendKeys(Keys.ENTER).perform();

    }
}