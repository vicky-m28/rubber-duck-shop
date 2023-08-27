package selenium.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.tests.page.objects.*;
import static org.testng.Assert.assertEquals;

@Listeners(ScreenshotListener.class)
@Epic("Cart functionality")

public class CartTests extends TestBase{
    private static String validEmail = "victoria.makarevich@gmail.com";
    private static String validPassword = "12345qwerty";
    private static String duckSize = "Medium +$2.50";
    private static String orderConfirmationMessage = "Your order is successfully completed!";

    @Feature("Order confirmation")
    @Description("Attempting to confirm order after login")
    @Test
    public static void ConfirmOrderTest(){
        LoginPage.attemptLogin(validEmail, validPassword);
        HeaderMenu.openCatalog();
        CatalogPage.openYellowDuckPage();
        DuckPage.selectSize(duckSize);
        DuckPage.addToCart();
        UpperPanel.openCart();
        CartPage.confirmOrder();
        assertEquals(OrderConfirmationPage.getConfirmationMessage(), orderConfirmationMessage);
    }

    @Feature("Base functionality")
    @Description("Verifying Cart page is loaded")
    @Test
    public static void cartPageLoaded(){
        UpperPanel.openCart();
        Assert.assertTrue(CartPage.hasLoaded());
    }
}
