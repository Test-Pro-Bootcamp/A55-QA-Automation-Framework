import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomeWorkPage;

public class HomeWork extends BaseTest{
    @Test
    public void deletePlayList(){
        HomeWorkPage homeWorkPage = new HomeWorkPage(driver);

        homeWorkPage.provideEmail("nayana.rao.subramanya@testpro.io");
        homeWorkPage.providePassword("Zqmvyk4hDaZ3vga");
        homeWorkPage.clickLogin();
        homeWorkPage.choosePlaylist();
        homeWorkPage.deletePlaylists();
        homeWorkPage.confirmDel();
    }
}
