package selenium.tests.page.objects;

import org.openqa.selenium.By;
import selenium.tests.locators.Locators;

import static selenium.tests.WebDriverContainer.getDriver;

public class OrderConfirmationPage {
    static String title = "Order Success | My Store";
    private static By confirmationMessageLocator = Locators.getLocator("OrderConfirmationPage.confirmationMessageLocator");

    public static String getConfirmationMessage(){
        return getDriver().findElement(confirmationMessageLocator).getText();
    }
}
