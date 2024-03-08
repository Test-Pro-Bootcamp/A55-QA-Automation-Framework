import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.ChangeThemePage;

public class ChangeThemeTest extends BaseTest{

    @Test(dataProvider = "themeData")
    public void ChooseDifferentThemes(String name, String xpath) throws InterruptedException {

        ChangeThemePage changeThemePage = new ChangeThemePage(getDriver());
        Boolean clicked = false;
        changeThemePage.login();

        while(!clicked){
            changeThemePage.navigateToProfilePg();
            System.out.println("The theme chosen is " + name + ".");
            //changeThemePage.chooseDifferentTheme(name, xpath);
            try {
            WebElement theme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.scrollToElement(theme).moveToElement(theme).build().perform();
            theme.click();

                clicked=true;
            }catch (Exception e) {
            wait.wait(1000);
            }
        }
    }
}
