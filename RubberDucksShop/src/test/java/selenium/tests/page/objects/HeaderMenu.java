package selenium.tests.page.objects;

import org.openqa.selenium.By;
import selenium.tests.locators.Locators;

import static selenium.tests.WebDriverContainer.getDriver;

public class HeaderMenu {
    private static By catalogLocator = Locators.getLocator("HeaderMenu.catalogLocator");

    public static void openCatalog(){
        getDriver().findElement(catalogLocator).click();
    }
}
