
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

/*
*
* Login Page variables table:
* Email     Password
*
* Valid     Valid
* Invalid   Valid
* Valid     Invalid
* Invalid   Invalid
* Empty     Valid
* Empty     Invalid
* Valid     Empty
* Invalid   Empty
* Empty     Empty
*
* */
public class LoginTests extends BaseTest {


   //Driver for parallel execution only with givenDriver() method to specify the driver in use.

    @Test
    public void loginValidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.avatarFound().isDisplayed());
        driver.close();
    }

    @Test
    public void invalidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("nayanarao.subramanya@testpro.io");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void validEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("abcd1234");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void emptyEmailValidPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }
    @Test
    public void emptyEmailemptyPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void validEmailEmptyPassword(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void InvalidEmailEmptyPass(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("kdnbdskfjbdakf@testpro.io");
        loginPage.providePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void EmptyEmailInvalidPass(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("");
        loginPage.providePassword("anhvdhg");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }
    @Test
    public void InvalidEmailInvalidPass(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("bdkjeqbfkjdbnsk@gmail.com");
        loginPage.providePassword("sbcjsabjd");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }


/*
    //Regular sequential execution of tests and specifying only one driver
    @Test
    public void loginValidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.avatarFound().isDisplayed());
        driver.close();
    }

    @Test
    public void invalidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nayanarao.subramanya@testpro.io");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void validEmailInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("abcd1234");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void emptyEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("Zqmvyk4hDaZ3vga");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }
    @Test
    public void emptyEmailemptyPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void validEmailEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("nayana.rao.subramanya@testpro.io");
        loginPage.providePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void InvalidEmailEmptyPass(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("kdnbdskfjbdakf@testpro.io");
        loginPage.providePassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }

    @Test
    public void EmptyEmailInvalidPass(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("anhvdhg");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }
    @Test
    public void InvalidEmailInvalidPass(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("bdkjeqbfkjdbnsk@gmail.com");
        loginPage.providePassword("sbcjsabjd");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.koelLogo().isDisplayed());
        driver.close();
    }*/
}


