package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangeThemePage extends BasePage{
    public ChangeThemePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Elements

    protected By profilePagenav = By.cssSelector("[href=\"/#!/profile\"]");


    public String selectedTheme;

    public void navigateToProfilePg(){
        findElement(profilePagenav).click();
    }

    public void checkCurrentTheme(){
        WebElement currentTheme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li/div[@class='theme selected']")));
        selectedTheme = currentTheme.getText();
        System.out.println("The current theme is "+selectedTheme+".");
    }

    public void chooseDifferentTheme(String name, String xpath){
        actions.moveToElement(findElement(By.xpath(xpath))).build().perform();
        actions.scrollToElement(findElement(By.xpath(xpath))).build().perform();
        WebElement chosenCurrentTheme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        chosenCurrentTheme.click();
        checkCurrentTheme();
    }

}
