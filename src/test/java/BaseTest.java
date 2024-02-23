import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;


    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setupBrowser(String baseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        launchWebsite(baseUrl);
        actions = new Actions(driver);
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    public void launchWebsite(String baseURL) {
        driver.navigate().to(baseURL);

        //driver.get(baseURL);
    }
    public void enterEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"email\"]")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"password\"]")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void loginButton(){
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type=\"submit\"]")));
        loginButton.click();
    }
    public void avatarIsDisplayed(){

        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"avatar\"]")));
        Assert.assertTrue(avatar.isDisplayed());
    }
    public void editButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul/li[3]/nav[@class='menu playlist-item-menu']/ul/li[1]")));
        WebElement editButton = driver.findElement(By.xpath("//section[@id='playlists']/ul/li[3]/nav[@class='menu playlist-item-menu']/ul/li[1]"));
        editButton.click();
    }
    public void renameTheSmartPlaylist(){
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"name\"]")));
        nameField.click();
        nameField.clear();
        nameField.sendKeys("New Smart");
    }
    public void saveSmartPlaylist(){
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"smart-playlist-form\"]//footer/button[@type=\"submit\"]")));
        saveButton.click();
    }
    public void successMessageSmartPlaylistIsDisplayed(){
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class='success show']")));
        Assert.assertEquals(successMessage.getText(),"Updated playlist \"New Smart.\"" );
    }
    public void renamePlaylistAction(){
        //Step: Navigate to the chosen playlist using xpath
        WebElement chosenPlaylist = driver.findElement(By.xpath("//section[@id='playlists']/ul//a[@href='#!/playlist/87052']"));
        wait.until(ExpectedConditions.visibilityOf(chosenPlaylist)).click();
        //Step: Right-click on the chosen playlist using actions
        actions.moveToElement(chosenPlaylist).doubleClick(chosenPlaylist).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='text']")));
        WebElement playlistNewNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul/li[@class='playlist playlist editing']/input[@type='text']")));
        actions.moveToElement(chosenPlaylist).doubleClick(playlistNewNameField).sendKeys(Keys.BACK_SPACE);
        playlistNewNameField.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
        //Step: Enter the new name
        playlistNewNameField.sendKeys("New name");
        //Step: Press the enter key
        playlistNewNameField.sendKeys(Keys.RETURN);
    }
}