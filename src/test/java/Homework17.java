import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



    public class Homework17 extends BaseTest {
        @Test
        //addSongToPlaylist
        public void addSongToPlaylist() throws InterruptedException {
            String expectedSongAddedSuccessMsq = "Added 1 song into \"1b.\"";


            //navigate to koel
           // navigateToPage();
            // login with valid credentials
            provideEmail("ionut.burtoiu@testpro.io");
            providePassword("Luca@20222");
            clickSubmit();

            //search for a song
            searchForSong("Episode 2");
            Thread.sleep(2000);

            //click "View All" button
            viewAllButton();
            Thread.sleep(2000);

            //click on the song
            clickOnTheSong();
            Thread.sleep(2000);

            //click on "ADD TO'
            clickAddTo();
            Thread.sleep(2000);


            //Choose the playlist
            choosePlaylist();
            Thread.sleep(2000);

            //Assertions
            Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedSuccessMsq);
            Thread.sleep(2000);
        }

        public void searchForSong(String songName) {
            WebElement searchTab = driver.findElement(By.cssSelector("input[type='search']"));
            searchTab.clear();
            searchTab.sendKeys(songName);

        }
        public void viewAllButton() {
            WebElement viewAll = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
            viewAll.click();
        }
        public void clickOnTheSong() {
            WebElement clickSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
            clickSong.click();
        }


        public void clickAddTo() {
            WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
            addToBtn.click();
        }
        public void choosePlaylist() {
            WebElement choosePlst = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(),'1b')]"));
            choosePlst.click();
        }

        public String getAddToPlaylistSuccessMsg() {
            WebElement notification = driver.findElement(By.cssSelector("div.success."));
            return notification.getText();

        }
    }


