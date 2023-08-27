package selenium.tests.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.tests.locators.Locators;

import java.time.Duration;

import static selenium.tests.WebDriverContainer.getDriver;

public class DuckPage extends PageBase {
    private static By sizeDropdownLocator = Locators.getLocator("DuckPage.sizeDropdownLocator");
    private static By addToCartButtonLocator = Locators.getLocator("DuckPage.addToCartButtonLocator");

    public static void selectSize(String sizeText){
        Select dropdown = new Select(getDriver().findElement(sizeDropdownLocator));
        dropdown.selectByVisibleText(sizeText);
    }

    public static void addToCart(){
        getDriver().findElement(addToCartButtonLocator).click();
        WebElement element = (new WebDriverWait(getDriver(), Duration.ofSeconds(5)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#cart span.quantity[style]")));
    }

}
