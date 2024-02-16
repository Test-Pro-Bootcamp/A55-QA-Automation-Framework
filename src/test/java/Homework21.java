import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import pages.LoginPage;

public class Homework21 extends BaseTest {


    private WebElement doubleClick;
    private Actions inputField;

    @Test
    public void renamePlaylist() throws InterruptedException {
        String updatedNameMsg = "Updated playlist \"Test Playlist.\"";
        //Step1: navigate and login to koel

        provideEmail("nicolai.luta@testpro.io");
        providePassword("tAPO0uuR");
        clickSubmit();
        Thread.sleep(5000);
        //Step2: doubleclick on playlist
        doubleClickPlaylist();
        //Step3: rename a playlist
        addNewNameToPlaylist();
        //Step4: check if we got notification message
        Assert.assertEquals(playlistMsg(), updatedNameMsg);


    }

    public String playlistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

    public void addNewNameToPlaylist() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputField.sendKeys("Test Playlist");
        inputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement doubleClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='dance']")));
        actions.doubleClick(doubleClick).perform();
    }
        
    }
    
    






