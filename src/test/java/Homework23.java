import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest{
    @Test

    public void renamePlaylist(){
        String newPlaylistName = "Test22";
        String updatedPlaylistMsg = "Updated playlist\"Test22.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.loginToKoelApp();
        homePage.doubleClickPlaylist();
        homePage.enterNewName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);
    }
}
