import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //navigate to page
        navigateToUrl();
        //login with to koel.app
        provideEmail("aida.taymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
        enterSongToSearchBar();
        clickViewAll();
        clickSong();
        clickAddTo();
        Assert.assertTrue(successPopOutMessage());
    }

    //From here and down these are not tests but helper methods
    public void enterSongToSearchBar() throws InterruptedException {
            WebElement SearchField = driver.findElement(By.cssSelector("input[type='search']"));
            SearchField.clear();
            Thread.sleep(2000);
            SearchField.sendKeys("Dark Days");
            SearchField.click();
            Thread.sleep(2000);
    }
    //helper method
    public void clickViewAll() throws InterruptedException {
        WebElement ViewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        ViewAllBtn.click();
        Thread.sleep(2000);
    }
    //helper method
    public void clickSong() throws InterruptedException {
        WebElement FirstSong = driver.findElement(By.xpath("//td[contains(text(),'Dark Days')]"));
         FirstSong.click();
        //Actions action = new Actions(driver);
        //action.contextClick(FirstSong).perform();
        Thread.sleep(2000);
    }
    //helper method
    public void clickAddTo(){
        //WebElement AddTo = driver.findElement(By.cssSelector("li[class='has-sub']"));
        WebElement AddTo = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        AddTo.click();
    }
    //helper method
    public void choosePlaylistName() throws InterruptedException {
        WebElement PlayListName = driver.findElement(By.cssSelector("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='test1']"));
        PlayListName.click();
        Thread.sleep(2000);
    }
    //helper method
    public boolean successPopOutMessage(){
        WebElement PopOut = driver.findElement(By.cssSelector("//div[@class='success show']"));
        Assert.assertTrue(PopOut.isDisplayed());
        //String expectedText = "Added 1 song to test1";
        //String actualText = driver.getText();
        //Assert.assertEquals(expectedText, actualText);
        //return PopOut.isDisplayed();
        return PopOut.isDisplayed();
    }


}
























