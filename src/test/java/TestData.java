import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name= "invalidLoginData")
    public static Object [][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalid@gmail.com", "invalidPassword"},
                {"kaflimeerim@gmail.com", " "},
                {" ", " "},
                {"invalid@gmail", "te$t$tudent"}
        };
    }
}
