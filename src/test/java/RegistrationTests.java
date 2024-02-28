import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest{

    public void successfulRegistrationMessage() {
        String messageExpected = "We've sent a confirmation link to the email. Please continue by clicking on it";
        WebElement messageActual = driver.findElement(By.xpath("//div[@class='login-wrapper']//div[@class='messages']"));
        String message = messageActual.getText();
        System.out.println(message);
        Assert.assertEquals(message, messageExpected);
    }
    @Test
    public void registrationNavigation() throws InterruptedException {
        //Step1: Click on the Registration link and assert that the correct page is opened
        WebElement registrationLink = driver.findElement(By.cssSelector("[href=\"registration\"]"));
        registrationLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/registration");

        //Step2: Access the email field and enter a valid email
        //It only accepts testpro.io emails
        WebElement emailField = driver.findElement(By.cssSelector("[type=\"email\"]"));
        emailField.clear();
        emailField.sendKeys("abcd@testpro.io");

        //Step3: Click on the submit button
        WebElement submitButton = driver.findElement(By.cssSelector("[id=\"button\"]"));
        submitButton.click();
        Thread.sleep(2000);

        //Step4: Assert that the message text is displayed using contains()
        successfulRegistrationMessage();
    }
}
