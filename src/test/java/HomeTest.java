import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class HomeTest extends BaseTest{



    @Test
    public void hoverOverPlayBtn() throws InterruptedException {
        //Login;
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        Thread.sleep(2000);
        //Assertion;
        Assert.assertTrue(hoverPlay().isDisplayed());
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']"))).isDisplayed();

    }
    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    @Test
    public void countSongsInPlaylist(){
        //login;
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        loginToKoel();
        //choosePlaylist;
        choosePlaylist("Green Song");
        //displayAllSongs;
        displayAllSongs();
        //Assertion;
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));

    }

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();

    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found:"+ countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());

        }
    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();


    }

    public void choosePlaylist(String playListName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playListName+"')]"))).click();

    }

    @Test
    public void renamePlaylist() throws InterruptedException {

        String updatedPlaylistSuccessMsg = "Updated playlist \"Sample Playlist.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewName();
        //Assertions;
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistSuccessMsg);

    }
    }

   /* public String getRenamePlaylistSuccessMsg(){
        WebElement notification =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    /*public void enterNewName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

   /* public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
}*/
