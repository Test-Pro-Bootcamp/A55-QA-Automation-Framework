import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class Homework_AddToPlaylist extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //Completed Steps 1 and 2, to initialize the "chrome driver" and to navigate to the url "https://qa.koel.app/"
        //Step3: create an email field variable and input your email id
        enterEmail();

        //Step4: create a password field variable and input your password
        enterPassword();

        //Step5: create a Login button variable and click it
        loginButton();

        //Step6: verify that the homepage has been opened
        WebElement mostPlayedList = driver.findElement(By.cssSelector("[class=\"top-song-list\"]"));
        Assert.assertTrue(mostPlayedList.isDisplayed());

        //Step7: navigate to the search field and input a song name
        searchFieldAccess();

        //Step8: click the view all button to display the search results
        WebElement viewAllButton = driver.findElement(By.xpath("//div[@class='results']//h1/button"));
        viewAllButton.click();

        //Step9: create a variable for the first song in the result displayed
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//div/table/tr[1]/td[2]"));
        firstSong.click();

        /*Right Click function for adding to Playlist
        Actions actions = new Actions(driver);
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//div/table/tr[1]/td[2]"));
        actions.contextClick(firstSong).perform();*/

        //Step10: Click the add to button
        WebElement addToButton = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToButton.click();

        //Step11: a method to add song to an existing playlist
        WebElement playlistName = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section[@class='existing-playlists']/ul/li[5]"));
        playlistName.click();
        Thread.sleep(1000);

        //Step 12: Assert notification message has been displayed with correct message
        String successfulAddSongMessage = "Added 1 song into \"My Music.\"";
        WebElement messageSuccess = driver.findElement(By.cssSelector("[class=\"success show\"]"));
        Assert.assertEquals(messageSuccess.getText() ,successfulAddSongMessage);
        Thread.sleep(4500);

        //Step13: a method to create a new playlist and add the song to it.
        goHome();
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchFieldAccess();

        viewAllButton.click();
        WebElement firstSongInList = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//table/tr[1]/td[2]"));
        firstSongInList.click();
        WebElement addToButtonRepeat = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToButtonRepeat.click();

        WebElement playlistField = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section[@class='new-playlist']/form/input[@required='required']"));
        playlistField.click();
        playlistField.clear();
        playlistField.sendKeys("New Playlist");
        playlistField.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        //Step13: Assert the notification message appears once the song is added to the playlist
        String successfulCreationOfPlaylistMessage = "Created playlist \"New Playlist.\"";
        WebElement messageSuccess1 = driver.findElement(By.cssSelector("[class=\"success show\"]"));
        Assert.assertEquals(messageSuccess1.getText(),successfulCreationOfPlaylistMessage);


    }
}
