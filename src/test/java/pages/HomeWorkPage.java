package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeWorkPage extends BasePage {

    public HomeWorkPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By playlistChosen = By.xpath("//*[@id=\"playlists\"]//a[text() = \"apple\"]");
    private By okBtn = By.xpath("//div[@class=\"alertify\"]//nav/button[@class=\"ok\"]");
    private By delBtn = By.cssSelector("[title=\"Delete this playlist\"]");
    private By successMsg = By.xpath("//div[@class=\"alertify-logs top right\"]/div[@class=\"success show\"]");

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickLogin(){
        findElement(submitBtn).click();
    }
    public void choosePlaylist(){findElement(playlistChosen).click();}
    public void deletePlaylists(){findElement(delBtn).click(); findElement(okBtn).click();}
    public void confirmDel(){WebElement success = (findElement(successMsg));
        Assert.assertEquals(success.getText(),"Deleted playlist \"apple.\"");}

}
