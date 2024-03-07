package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ChangeThemePage extends BasePage{
    public ChangeThemePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Elements

    protected By profilePagenav = By.cssSelector("[href=\"/#!/profile\"]");

    protected By currentTheme = By.xpath("//section[@id='profileWrapper']//ul[@class='themes']/li/div[@class='theme selected']/div");

    public String currentThemeName;

    @DataProvider(name="themeData")
    public static Object[][] NewTheme(){

        Object [][] themeChoice=new Object[15][1];

        themeChoice[0][0]="";
        themeChoice[1][0]="";
        themeChoice[2][0]="";
        themeChoice[3][0]="";
        themeChoice[4][0]="";
        return themeChoice;
    }


}
