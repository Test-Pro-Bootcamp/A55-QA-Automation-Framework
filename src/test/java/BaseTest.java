import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
WebDriver driver;
    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickBtn(){
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitBtn.click();
    }
    public void searchASong(String songName){
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(songName);
    }
    public void clickViewAllBtn(){
        WebElement viewAllBtn= driver.findElement(By.cssSelector("[data-test=view-all-songs-btn]"));
        viewAllBtn.click();
    }
    public void chooseASong(){
        WebElement firstSong = driver.
                findElement(By.cssSelector("section[id='songResultsWrapper'] tr:nth-child(1) td:nth-child(1)"));
    firstSong.click();
    }
    public void clickAddToBtn(){
        WebElement AddToPlaylist = driver.findElement(By.cssSelector("[data-test=add-to-btn]"));
        AddToPlaylist.click();
    }
    public void choosePlaylist(String playlistName) throws InterruptedException {
        WebElement choosePlaylist1  = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='"+playlistName+"']"));
        choosePlaylist1.click();
        Thread.sleep(4000);

    }
    public boolean songAddedToPlaylist(){
        WebElement messagePopUp=  driver.findElement(By.cssSelector("[class='success show']"));
        return messagePopUp.isDisplayed();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}