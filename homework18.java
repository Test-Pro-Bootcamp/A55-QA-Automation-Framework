import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class homework18 extends BaseTest{
    @Test
    public void playSong(){
        // login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        loginToKoel();
        // click on play button
        clickPlay();
        // Assertion
    }

    private void clickPlay() {
        WebElemement playNextBtn = driver.findElement(By.xpath)
    }
}
