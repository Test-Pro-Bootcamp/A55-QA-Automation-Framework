import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class RegisterTest extends BaseTest{
    @Test
    public void registrationNavigation() {
        //Preconditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //Declarations
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Step1: Navigate to the Koel app URL and assert that then right page is opened
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Step2: Click on the Registration link and assert that the correct page is opened
        WebElement registrationLink = driver.findElement(By.cssSelector("[href=\"registration\"]"));
        registrationLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");

        //Step3: Access the email field and enter a previously unused/fake email
            //It only accepts testpro.io emails
        WebElement emailField = driver.findElement(By.cssSelector("[type=\"email\"]"));
        emailField.clear();
        emailField.sendKeys("abcd@testpro.io");

        //Step4: Click on the submit button
        WebElement submitButton = driver.findElement(By.cssSelector("[id=\"button\"]"));
        submitButton.click();

        //Step5: Assert that the message text is displayed using contains()
            //"We've sent a confirmation link to the email. Please continue by clicking on it"
        String messageExpected = "We've sent a confirmation link to the email. Please continue by clicking on it";
        WebElement messageActual = driver.findElement(By.xpath("//body//form[@method='POST']/div[@class='messages']"));
        Assert.assertEquals(messageActual.getText(), messageExpected);

        //Step6: Close all open windows in the browser.
        driver.quit();
    }

}
