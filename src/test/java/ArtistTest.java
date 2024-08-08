import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArtistPage;
import pages.LoginPage;


public class ArtistTest extends BaseTest{
    @Test
    public void checkForArtistPage() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        ArtistPage artistPage = new ArtistPage(getThreadLocal());

        loginPage.loginMainPage();
        artistPage.clickArtistNavBar();
        Assert.assertTrue(artistPage.checkArtist());
    }
}
