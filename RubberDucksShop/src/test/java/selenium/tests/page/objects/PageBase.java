package selenium.tests.page.objects;

import static selenium.tests.WebDriverContainer.getDriver;

public class PageBase {
    protected static boolean hasLoaded(String title){
        return getDriver().getTitle().equals(title);
    }
}
