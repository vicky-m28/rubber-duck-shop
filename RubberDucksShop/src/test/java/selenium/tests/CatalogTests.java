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
@Epic("Catalog functionality")

public class CatalogTests extends TestBase {
    private static String duckSize = "Medium +$2.50";
    private static String expectedItemsQuantity = "1";
    private static String yellowDuckLabel ="Yellow Duck";

    @Feature("Add to cart functionality")
    @Description("Attempting to add Yellow Duck to cart")
    @Test
    public static void AddToCartTest(){
        HeaderMenu.openCatalog();
        CatalogPage.openYellowDuckPage();
        DuckPage.selectSize(duckSize);
        DuckPage.addToCart();
        assertEquals(UpperPanel.getItemsQuantity(),expectedItemsQuantity);
        UpperPanel.openCart();
        assertEquals(CartPage.getDuckLabel(),yellowDuckLabel);
    }

    @Feature("Sorting functionality")
    @Description("Attempting to sort by name")
    @Test
    public static void SortingInCatalogTest(){
        HeaderMenu.openCatalog();
        CatalogPage.sortByName();
        for (int i = 0; i<CatalogPage.getActualSortedByNameList().size(); i++){
            assertEquals(CatalogPage.getActualSortedByNameList().get(i), CatalogPage.getExpectedSortedByNameList().get(i));
        }
    }

    @Feature("Base functionality")
    @Description("Verifying Catalog page is loaded")
    @Test
    public static void catalogPageLoaded(){
        HeaderMenu.openCatalog();
        Assert.assertTrue(CatalogPage.hasLoaded());
    }
}
