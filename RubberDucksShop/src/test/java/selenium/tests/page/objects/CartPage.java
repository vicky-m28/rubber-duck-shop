package selenium.tests.page.objects;
import org.openqa.selenium.By;
import selenium.tests.locators.Locators;

import static selenium.tests.WebDriverContainer.getDriver;

public class CartPage extends PageBase {
    static String title = "Checkout | My Store";
    private static By duckLabelLocator = Locators.getLocator("CartPage.duckLabelLocator");
    private static By confirmOrderLocator = Locators.getLocator("CartPage.confirmOrderLocator");

    public static boolean hasLoaded(){
        return hasLoaded(title);
    }
    public static String getDuckLabel(){
        return getDriver().findElement(duckLabelLocator).getText();
    }

    public static void confirmOrder(){
        getDriver().findElement(confirmOrderLocator).click();
    }
}
