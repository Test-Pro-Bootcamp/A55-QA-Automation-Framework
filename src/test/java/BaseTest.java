import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseTest {
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();}

    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //Helper method
    public void loginToKoel() {
        WebElement loginBtn =  driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        //Thread.sleep(5000);
    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void navigateToPage() {
        driver.get(url);
    }
    public WebDriver driver;
    public String url = "https://qa.koel.app/";

    public void searchForSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(songName);
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void clickFirstSongResult() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();

    }

    public void choosePlayList() {
        WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contain(text(),'first playlist')]"));
        playList.click();
    }

    public String getAddToPlaylistSuccesMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }




}