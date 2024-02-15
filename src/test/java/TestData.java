import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name="invalidLoginData")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"invalid@email.com", "invalidPassword"},
                {"demo@class.com", ""},
                {"", ""}
                {"invalid@email.com", "te$t$tudent"}
        };
    }

}
