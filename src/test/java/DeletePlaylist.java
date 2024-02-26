import org.testng.annotations.Test;
import pages.DeletePlaylistPage;
import pages.LoginPage;

public class DeletePlaylist extends BaseTest{
    @Test
    public void deletePlayList(){
        DeletePlaylistPage deletePlaylistPage = new DeletePlaylistPage(driver);

        deletePlaylistPage.provideEmail("nayana.rao.subramanya@testpro.io");
        deletePlaylistPage.providePassword("Zqmvyk4hDaZ3vga");
        deletePlaylistPage.clickLogin();
        deletePlaylistPage.choosePlaylist();
        deletePlaylistPage.deletePlaylists();
        deletePlaylistPage.confirmDel();
    }
}
