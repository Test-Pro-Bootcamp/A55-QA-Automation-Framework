import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void AddSongToPlaylist() {
        //navigate to page
        navigateToUrl();
        //login with to koel.app
        provideEmail("aidataymaskhanova@testpro.io");
        providePassword("Ozzikpozzik18");
        clickSubmit();
        LocateSearchBar();
        EnterSongInSearchBar();
        //click submit
        // click all songs
        // click first song on the page

    }



    public void LocateSearchBar(){
            WebElement SearchField = driver.findElement(By.cssSelector("input[type='search']"));
            SearchField.clear();
            SearchField.sendKeys("Dark Days");
            SearchField.clear();
            SearchField.click();
    }

    public void EnterSongInSearchBar() {

    }

    public void clickViewAll() {
        WebElement ViewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        ViewAllBtn.click();
    }









        //Assertion (expected vs actual)
        //WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assert.assertTrue(avatar.isDisplayed());


    }


    }









