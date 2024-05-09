package Sprint6StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.time.Duration;

public class Sprint6LoginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @After
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open page")
    public void iOpenPage() {
       driver.get("https://qa.koel.app");

    }

    @When("I enter the email {string}")
    public void iEnterTheEmail(String email) {
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @And("I click on koel login button")
    public void iClickOnKoelLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
    }

    @Then("I should now be logged in")
    public void iShouldNowBeLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @And("I select + by playlist")
    public void iSelectByPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > h1 > i"))).click();
    }

    @And("I select New Smart Playlist")
    public void iSelectNewSmartPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > nav > ul > li:nth-child(2)"))).click();
    }


    @And("I enter SprintSix into NAME field")
    public void iEnterSprintSixIntoNAMEField() {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div:nth-child(1) > input[type=text]")));
        nameField.sendKeys("SprintSix");
    }

    @And("I select dropdown that Title Contains")
    public void iSelectDropdownThatTitleContains() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > div > div.row > select:nth-child(3)")));

        Select select = new Select(dropdown);
        select.selectByVisibleText("contains");
    }

    @And("I enter the letter a")
    public void iEnterTheLetterA() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > div > div.row > span > input[type=text]")));
        inputField.sendKeys("a");
    }

    @And("I select SAVE")
    public void iSelectSAVE() {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > footer > button:nth-child(1)")));
        saveButton.click();
    }
    @Then("New Smart Playlist SprintSix appears in the sidebar")
    public void newSmartPlaylistSprintSixAppearsInTheSidebar() {
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists")));
        String sidebarText = sidebar.getText();
        System.out.println("Sidebar Test: " + sidebarText);
        Assert.assertTrue("SprintSix Playlist should appear in the sidebar", sidebarText.contains("SprintSix"));
    }


    //Scenario: Create a Smart playlist in app with multiple rules
    @And("I enter SprintSix.MultipleRules into NAME field")
    public void iEnterSprintSixMultipleRulesIntoNAMEField() {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div:nth-child(1) > input[type=text]")));
        nameField.sendKeys("SprintSix.MultipleRules");
    }
    @And("I select the ADD RULE button")
    public void iSelectTheADDRULEButton() {
        WebElement addRule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > div > button")));
        addRule.click();
    }

    @And("I select dropdown that Title Begins With")
    public void iSelectDropdownThatTitleBeginsWith() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > div > div:nth-child(3) > select:nth-child(3)")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("begins with");
    }

    @And("I enter the letter a again")
    public void iEnterTheLetterAAgain() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > div > div:nth-child(3) > span > input[type=text]")));
        inputField.sendKeys("a");
    }

    @Then("New Smart Playlist SprintSix.MultipleRules appears in the sidebar")
    public void newSmartPlaylistSprintSixMultipleRulesAppearsInTheSidebar() {
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists")));
        String sidebarText = sidebar.getText();
        System.out.println("Sidebar Test: " + sidebarText);
        Assert.assertTrue("SprintSix.MultipleRules Playlist should appear in the sidebar", sidebarText.contains("SprintSix.MultipleRules"));
    }

//Scenario: Create a Smart playlist in app with Group
    @And("I enter SprintSix.Group into NAME field")
    public void iEnterSprintSixGroupIntoNAMEField() {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div:nth-child(1) > input[type=text]")));
        nameField.sendKeys("SprintSix.Group");
    }

    @And("I select the GROUP button")
    public void iSelectTheGROUPButton() {
        WebElement addGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > button")));
        addGroup.click();
    }

    @And("I select second dropdown that Title Contains")
    public void iSelectSecondDropdownThatTitleContains() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > div:nth-child(2) > div.row > select:nth-child(3)")));
        Select select = new Select(dropdown);
        select.selectByVisibleText("does not contain");

    }

    @And("I enter the letter b")
    public void iEnterTheLetterB() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mainWrapper > div > div > div > form > div > div.form-row.rules > div:nth-child(2) > div.row > span > input[type=text]")));
        inputField.sendKeys("b");

    }

    @Then("New Smart Playlist SprintSix.Group appears in the sidebar")
    public void newSmartPlaylistSprintSixGroupAppearsInTheSidebar() {
        WebElement sidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists")));
        String sidebarText = sidebar.getText();
        System.out.println("Sidebar Test: " + sidebarText);
        Assert.assertTrue("SprintSix.Group Playlist should appear in the sidebar", sidebarText.contains("SprintSix.Group"));
    }


}


