package selenium.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.tests.page.objects.LoginPage;
import static org.testng.Assert.assertEquals;

@Listeners(ScreenshotListener.class)
@Epic("Core functionality")

public class LoginTests extends TestBase {
    private static String validEmail = "victoria.makarevich@gmail.com";
    private static String validPassword = "12345qwerty";
    private static String invalidPassword = "test123";
    private static String successNoticeMessage = "You are now logged in as Victoria Valakhanovich.";
    private static String failNoticeMessage = "Wrong password or the account is disabled, or does not exist";


    @Feature("Login functionality")
    @Description("Login with valid credentials")
    @Test
    public static void LoginWithValidCredentials(){
        LoginPage.attemptLogin(validEmail, validPassword);
        String noticeMessage = LoginPage.getNoticeMessage();
        assertEquals(noticeMessage,successNoticeMessage);
    }

    @Feature("Login functionality")
    @Description("Login with invalid password")
    @Test
    public static void LoginWithInvalidCredentials(){
        LoginPage.attemptLogin(validEmail, invalidPassword);
        String noticeMessage = LoginPage.getNoticeMessage();
        assertEquals(noticeMessage,failNoticeMessage);
    }

}
