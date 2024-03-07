package step_definition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class LoginStepDef {

    public WebDriver driver;
    public WebDriverWait wait;

    @Given("Open the browser")
    public void openTheBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("navigate to koel website")
    public void navigateToKoelWebsite() {
        driver.get("https://qa.koel.app/");
    }


    @Then("website opens with input fields for email and password; submit button for login")
    public void websiteOpensWithInputFieldsForEmailAndPasswordSubmitButtonForLogin() {
        WebElement koelSym = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='logo']")));
        Assert.assertTrue(koelSym.isDisplayed());
    }


    @And("koel logo is visible")
    public void koelLogoIsVisible() {
        WebElement koelLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='logo']")));
        Assert.assertTrue(koelLogo.isDisplayed());
    }

    @When("enter valid email address and valid password and click on login button")
    public void enterValidEmailAddressAndValidPasswordAndClickOnLoginButton() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.sendKeys("nayana.rao.subramanya@testpro.io");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordField.sendKeys("Zqmvyk4hDaZ3vga");
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        submitBtn.click();
    }

    @Then("homepage is opened with avatar icon visible.")
    public void homepageIsOpenedWithAvatarIconVisible() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='/#!/profile']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @When("enter invalid email address and valid password and click on login button")
    public void enterInvalidEmailAddressAndValidPasswordAndClickOnLoginButton() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailField.sendKeys("rao.s@testpro.io");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));

        passwordField.sendKeys("Zqmvyk4hDaZ3vga");
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        submitBtn.click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
