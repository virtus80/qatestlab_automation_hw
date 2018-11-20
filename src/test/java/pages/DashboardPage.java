package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    public static final By catalogItem = By.id("subtab-AdminCatalog");
    public static final By categoriesSubitem = By.id("subtab-AdminCategories");

    public static void gotoCategoriesPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogItem));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(catalogItem)).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSubitem));
        driver.findElement(categoriesSubitem).click();
    }
}
