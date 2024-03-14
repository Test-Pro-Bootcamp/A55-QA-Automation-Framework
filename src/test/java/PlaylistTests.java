
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTests extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.login();
        homePage.selectPlaylist();
        homePage.clickDeletePlaylistBtn();
        Thread.sleep(2000);
        homePage.getPlaylistDeletedMessage();

       // Assert.assertEquals(getPlaylistDeletedMessage(),deletedPlaylistSuccessMessage);
        Assert.assertTrue(homePage.getPlaylistDeletedMessage());

                /*String deletedPlaylistSuccessMessage = "Deleted playlist \"Oreo.\"";
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        selectPlaylist();
        Thread.sleep(2000);
        clickDeletePlaylistBtn();
        Thread.sleep(2000);
        Assert.assertEquals(getPlaylistDeletedMessage(),deletedPlaylistSuccessMessage);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show"))).isDisplayed();



    public String getPlaylistDeletedMessage(){
       // WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }



    public void clickDeletePlaylistBtn() {
       // WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@title= 'Delete this playlist']"));
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title= 'Delete this playlist']")));
        deletePlaylistBtn.click();
    }

    public void selectPlaylist() {
        //WebElement playlistName = driver.findElement(By.xpath("//a[contains(text(),'Oreo')]"));/
        WebElement playlistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Oreo')]")));
        playlistName.click();


    }
}*/
}
}

