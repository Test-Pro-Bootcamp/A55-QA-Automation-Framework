package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecentlyPlayedPage extends BasePage{

    public RecentlyPlayedPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //elements
    static By recentlyPlayedPage = By.cssSelector("a[href='#!/recently-played']");
    static By AllBtn = By.cssSelector("button.btn-shuffle-all");
    static By ClearAllBtn = By.cssSelector("button[title='Clear current queue']");
    static By NoSongsQueuedText = By.cssSelector("div.text");

    public static void clickRecentlyPlayedBtn(){
        findElement(recentlyPlayedPage).click();
    }
    public static void clickAllBtn(){
        findElement(AllBtn).click();
    }

    public static void clickClearBtn(){
        findElement(ClearAllBtn).click();
    }

    public static WebElement getTextForClearedRecentlyPlayedPage() {
        return findElement(NoSongsQueuedText);
    }



}
