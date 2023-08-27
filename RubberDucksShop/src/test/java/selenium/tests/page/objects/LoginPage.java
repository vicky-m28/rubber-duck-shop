package selenium.tests.page.objects;

import org.openqa.selenium.By;
import selenium.tests.locators.Locators;

import static selenium.tests.WebDriverContainer.getDriver;

public class LoginPage {
    private static By emailLocator = Locators.getLocator("LoginPage.emailLocator");
    private static By passwordLocator = Locators.getLocator("LoginPage.passwordLocator");
    private static By loginButtonLocator = Locators.getLocator("LoginPage.loginButtonLocator");
    private static By NoticeLocator = Locators.getLocator("LoginPage.NoticeLocator");

    public static void attemptLogin(String email, String password){
        getDriver().findElement(emailLocator).sendKeys(email);
        getDriver().findElement(passwordLocator).sendKeys(password);
        getDriver().findElement(loginButtonLocator).click();

    }
    public static String getNoticeMessage(){
        return getDriver().findElement(NoticeLocator).getText();
    }
}
