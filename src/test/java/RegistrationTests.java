import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest{

   @Test
    public void registrationSuccess(){
       RegistrationPage registrationPage = new RegistrationPage(getDriver());

       registrationPage.clickOnRegistrationLink();
       registrationPage.confirmLandingOnRegPg();
       registrationPage.enterEmail();
       registrationPage.clickSubmit();
       registrationPage.confirmSuccess();
   }
}
