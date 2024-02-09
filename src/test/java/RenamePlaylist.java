import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class RenamePlaylist extends BaseTest {

    @BeforeMethod
    @Parameters({"BaseURL", "Email", "Password"})

    public void start(String baseURL, String email, String password) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        actions = new Actions(driver);

        loginValidEmailPassword(baseURL, email, password);
    }

    private void loginValidEmailPassword(String baseURL, String email, String password) {
        //Steps 1: Open Browser and navigate to Koel app.
        navigateToPage(baseURL);
        //Step 2: Enter email
        provideEmail(email);
        //Step 3: Enter Password
        providePassword(password);
        //Step 4: Click on Login button
        loginToKoel();
        //Assertion (expected vs actual)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    @Parameters({"PlayList"})
    public void RenamePlayList(String playlist) throws InterruptedException {
        clickPlusButton();
        chooseNewPlaylist();
        enterPlaylistName(playlist);

        String createdMsg = "Created playlist \"" + playlist + ".\"";
        Assert.assertEquals(getNotification(), createdMsg);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));


        String newName = playlist +"-renamed";
        renamePlaylist(playlist, newName);

        String message = "Updated playlist \"" + newName + ".\"";
        Assert.assertEquals(getNotification(), message);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.success.show")));

        //Click the playlist you want to rename.
        clickPlaylist(newName);
        deleteButton();

        //  Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".
        message = "Deleted playlist \"" + newName + ".\"";
        Assert.assertEquals(getNotification(), message);
    }

    public void  renamePlaylist (String oldName, String newName) throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//a[text()='"+ oldName +"']"));

        actions.moveToElement(playlist).build().perform();
        actions.pause(100).build().perform();
        actions.contextClick(playlist).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//nav[@class='menu playlist-item-menu']//li[text()='Edit']")));
        edit.click();

        WebElement playlistNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        playlistNameField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), newName);
        playlistNameField.sendKeys(Keys.ENTER);
    }

    public void clickPlaylist(String playlist) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement playlistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[text()='"+ playlist +"']")));
        playlistBtn.click();
    }

    public String getNotification() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));

        return notificationMsg.getText();
    }

    public void enterPlaylistName(String newPlaylistName) {
        WebElement playlistNameField = driver.findElement(By.cssSelector("input[placeholder='↵ to save']"));
        playlistNameField.clear();
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }

    public void chooseNewPlaylist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > nav > ul > li:nth-child(1)")));
        newPlaylist.click();
    }

    public void clickPlusButton() throws InterruptedException {
        WebElement btn = driver.findElement(By.cssSelector("#playlists > h1 > i"));
        Actions s = new Actions(driver);
        s.moveToElement(btn).build().perform();
        s.pause(100).build().perform();
        s.click(btn).build().perform();
    }

    public void deleteButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deleteBtn.click();
    }


}
