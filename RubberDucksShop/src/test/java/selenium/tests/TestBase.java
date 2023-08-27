package selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static selenium.tests.WebDriverContainer.getDriver;
import static selenium.tests.WebDriverContainer.quitDriver;

public class TestBase {
    private static String url = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void setup(){
        getDriver().get(url);
    }

    @AfterMethod
    public void quit(){
        quitDriver();
    }
}
