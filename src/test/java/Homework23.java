import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;

import java.time.Instant;

public class Homework23 extends BaseTest {

    String createdPlaylist = "Created playlist \"vivo.\"";
    String updatedPlaylistMsg = "Updated playlist \"VIVO.\"";


    @Test
    public void createPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.clickPlusButton();
        homePage.chooseNewPlaylist();
        homePage.enterPlaylistName("vivo");
        Assert.assertEquals(homePage.playlistCreated(), createdPlaylist);


    }

    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.doubleClickPlaylist();
        homePage.addNewNameToPlaylist();
        Assert.assertEquals(homePage.playlistMsgSuccess(), updatedPlaylistMsg);

    }

}

