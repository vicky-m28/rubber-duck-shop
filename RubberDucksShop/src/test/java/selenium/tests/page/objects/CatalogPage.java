package selenium.tests.page.objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.tests.locators.Locators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static selenium.tests.WebDriverContainer.getDriver;

public class CatalogPage extends PageBase {
    private static Logger LOG = Logger.getLogger(CatalogPage.class);

    static String title = "Rubber Ducks | My Store";
    private static By yellowDuckLocator = Locators.getLocator("CatalogPage.yellowDuckLocator");
    private static By sortByNamelocator = Locators.getLocator("CatalogPage.sortByNameLocator");
    private static By duckNameLocator = Locators.getLocator("CatalogPage.duckNameLocator");

    public static boolean hasLoaded(){
        return hasLoaded(title);
    }
    public static void openYellowDuckPage(){
        getDriver().findElement(yellowDuckLocator).click();
    }
    public static void sortByName(){
        LOG.info("Attempting to click Sort By Name button");
        getDriver().findElement(sortByNamelocator).click();
    }

    public static ArrayList<String> getActualSortedByNameList(){
        List <WebElement> duckNames = getDriver().findElements(duckNameLocator);
        ArrayList<String> duckNamesActual = new ArrayList<>();
        for (WebElement duckName : duckNames) {
            String s = duckName.getText();
            duckNamesActual.add(s);
        };
        return duckNamesActual;
    }

    public static ArrayList<String> getExpectedSortedByNameList(){
        ArrayList<String> duckNamesExpected = new ArrayList<>();
        for (int i = 0; i < getActualSortedByNameList().size(); i++) {
            duckNamesExpected.add(getActualSortedByNameList().get(i));
        }
        Collections.sort(duckNamesExpected, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        return duckNamesExpected;
    }

}
