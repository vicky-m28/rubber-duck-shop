package selenium.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static selenium.tests.Browser.*;

public class WebDriverContainer {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            try {
                initDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    public static void initDriver() throws MalformedURLException {
        Browser browser = Browser.getEnumByLabel(System.getProperty("browser", CHROME.getBrowserName()));
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser.getBrowserName());
        caps.setPlatform(Platform.WIN11);
        driver = new RemoteWebDriver(new URL("http://192.168.100.27:4444/wd/hub"), caps);

/*      driver = switch (browser){
            case CHROME -> new ChromeDriver();
            case EDGE -> new EdgeDriver();
            case FIREFOX -> new FirefoxDriver();
            case SAFARI -> new SafariDriver();
        };*/

        driver.manage().window().maximize();
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
