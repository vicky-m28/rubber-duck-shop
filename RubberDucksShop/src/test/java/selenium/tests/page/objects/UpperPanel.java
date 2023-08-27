package selenium.tests.page.objects;

import org.openqa.selenium.By;
import selenium.tests.locators.Locators;

import static selenium.tests.WebDriverContainer.*;

public class UpperPanel {
    private static By itemsQuantityLocator = Locators.getLocator("UpperPanel.itemsQuantityLocator");
    private static By cartIconLocator = Locators.getLocator("UpperPanel.cartIconLocator");
    public static void openCart(){
        getDriver().findElement(cartIconLocator).click();
    }

    public static String getItemsQuantity(){
        return getDriver().findElement(itemsQuantityLocator).getText();
    }

}
