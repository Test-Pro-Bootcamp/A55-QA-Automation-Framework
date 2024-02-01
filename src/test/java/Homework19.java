import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        enterEmail();
        enterPassword();
        loginButton();
        ChoosePlaylist();
        deleteThePlaylist();
        confirmDeletion();
    }

    private void confirmDeletion() {
        String successMessage = "Deleted playlist \"apple.\"";
        WebElement messageSuccess = driver.findElement(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class=\"success show\"]"));
        Assert.assertEquals(messageSuccess.getText(),successMessage);
    }

    private void deleteThePlaylist() throws InterruptedException {
        WebElement deleteButton = driver.findElement(By.cssSelector("[title=\"Delete this playlist\"]"));
        deleteButton.click();
        WebElement okayButton = driver.findElement(By.xpath("//div[@class=\"alertify\"]//nav/button[@class=\"ok\"]"));
        okayButton.click();
        Thread.sleep(900);
    }

    private void ChoosePlaylist() {
        WebElement chosenPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]//a[text() = \"apple\"]"));
        chosenPlaylist.click();
    }
}
