import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework20 extends BaseTest{
    @Test
    public void deletePlaylist(){
        enterEmail("nayana.rao.subramanya@testpro.io");
        enterPassword("Zqmvyk4hDaZ3vga");
        loginButton();
        ChoosePlaylist();
        deleteThePlaylist();
        confirmDeletion();
    }

    private void confirmDeletion() {
        String successMessage = "Deleted playlist \"apple.\"";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class=\"success show\"]")));
        WebElement messageSuccess = driver.findElement(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class=\"success show\"]"));
        Assert.assertEquals(messageSuccess.getText(),successMessage);
    }

    private void deleteThePlaylist() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title=\"Delete this playlist\"]")));
        deleteButton.click();
        WebElement okayButton = driver.findElement(By.xpath("//div[@class=\"alertify\"]//nav/button[@class=\"ok\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(okayButton)).click();
    }

    private void ChoosePlaylist() {
        WebElement chosenPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]//a[text() = \"apple\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(chosenPlaylist)).click();
    }
}
