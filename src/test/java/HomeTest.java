import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{
    String newPlaylistName = "Test21";

    @Test
    public void hoverOverPlayButton()  {
    provideEmail("ionut.burtoiu@testpro.io");
       providePassword("Luca@20222");
    clickSubmit();
    //Thread.sleep(3000);
        Assert.assertTrue(hoverPlay().isDisplayed());
        //Thread.sleep(2000);
    }
    @Test
    public void countSongsInPlaylist(){

        //login
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();
        // choose playlist by name
        choosePlaylistByName("1b");

        //displayAllSongs
        displayAllSongs();

        //Assertions
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }




    @Test
    public void renamePlaylist() throws InterruptedException {

        String updatedPlaylistSuccessMSG ="Updated playlist\"Test21.\"";
        //login
        provideEmail("ionut.burtoiu@testpro.io");
        providePassword("Luca@20222");
        clickSubmit();
        Thread.sleep(2000);
        //double click playlist
        doubleClickPlaylist();
        Thread.sleep(2000);
        //enter new name
        enterNewName();
        //assertions
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistSuccessMSG);
    }
public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
}
    public void enterNewName() {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'1b')]")));
        actions.doubleClick(playlistElement).perform();

    }

    public String getPlaylistDetails(){
        return driver.findElement(By.xpath("//span[@class='meta']")).getText();
    }

    public void displayAllSongs() {
      List<WebElement> songList = driver.findElements(By.xpath("//section[@id='playlistWrapper']//table//tr//td[@class='title']"));
        System.out.println("Number of Songs found: " + countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }

    public int countSongs() {
        return driver.findElements(By.xpath("//section[@id='playlistWrapper']//table//tr//td[@class='title']")).size();
   }

    public void choosePlaylistByName(String playListName) {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playListName + "')]"))).click();
    }


    public WebElement hoverPlay () {
            WebElement play = driver.findElement(By.xpath("//span[@data-testid='play-btn'] "));
            actions.moveToElement(play).perform();
            return wait.until(ExpectedConditions.visibilityOf(play));

        }


    }