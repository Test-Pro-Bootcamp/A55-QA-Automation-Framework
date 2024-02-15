import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RecentlyPlayedPage;
import pages.LogInPage;

public class ClearCurrentQueTest extends BaseTest {
    @Test
    public void playSongFromArtistsPage() {
        //prerequisites
        LogInPage loginPage = new LogInPage(driver);
        LogInPage.provideEmail("aida.taymaskhanova@testpro.io");
        LogInPage.providePassword("Ozzikpozzik18");
        LogInPage.clickSubmit();
        //when
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(driver);
        RecentlyPlayedPage.clickRecentlyPlayedBtn();
        RecentlyPlayedPage.clickAllBtn();
        RecentlyPlayedPage.clickClearBtn();
        //then
        Assert.assertTrue(RecentlyPlayedPage.getTextForClearedRecentlyPlayedPage().isDisplayed());

    }



}
