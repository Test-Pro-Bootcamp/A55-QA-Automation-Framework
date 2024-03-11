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
import pages.BasePage;
import pages.LoginPage;

import static org.openqa.selenium.By.cssSelector;

public class HomeWork22 extends BaseTest2{
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedPlayListMsg = "Updated playlist \"Test1.\"";

        loginPage.loginMainPage();
        selectPlayList();

        Assert.assertEquals(getUpdatedPlaylistMsg(), expectedPlayListMsg);

    }

    public String getUpdatedPlaylistMsg() {
        WebElement playListMsg = driver.findElement(cssSelector("div.success.show"));
        return playListMsg.getText();
    }

    public void selectPlayList() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement selectPlayListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        //WebElement selectPlayList = driver.findElement(cssSelector(".playlist:nth-child(3)"));

        Actions action = new Actions(driver);
        action.doubleClick(selectPlayListElement);
        action.doubleClick(selectPlayListElement);
        action.sendKeys(selectPlayListElement,Keys.CLEAR).perform();

        action.sendKeys("Test1").perform();
        action.sendKeys(Keys.ENTER).perform();

    }
}
