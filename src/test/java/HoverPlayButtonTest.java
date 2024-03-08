import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverPlayButtonPage;

public class HoverPlayButtonTest extends BaseTest{
    @Test
    public void hoverOverPlay(){
        HoverPlayButtonPage hoverPlayButtonPage = new HoverPlayButtonPage(driver);

        hoverPlayButtonPage.login();
        WebElement avataar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"avatar\"]")));
        Assert.assertTrue(avataar.isDisplayed());
        hoverPlayButtonPage.hoverPlay();
        hoverPlayButtonPage.playButtonClick();
        hoverPlayButtonPage.isSongPlaying();
    }
}
