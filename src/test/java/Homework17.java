import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{



    @Test
    public void addSongToPlaylist() throws InterruptedException {
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickBtn();
        WebElement avatarIcon= driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());
      searchASong("Dark Days");
      clickViewAllBtn();
      chooseASong();
        clickAddToBtn();
      choosePlaylist("vivo");
      Assert.assertTrue(songAddedToPlaylist());
    }

}
