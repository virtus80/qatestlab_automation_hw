package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CategoryPage extends BasePage{

    public static final By addNewCategoryButton = By.id("page-header-desc-category-new_category");
    public static final By nameFilter = By.name("categoryFilter_name");
    public static final By resetFilterButton = By.name("submitResetcategory");
    public static final By searchFilterButton = By.id("submitFilterButtoncategory");
    public static final By nameCategoryCell = By.cssSelector("#table-category tbody td:nth-of-type(3)");

    public static void initAddingCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addNewCategoryButton));
        driver.findElement(addNewCategoryButton).click();
    }

    public static void searchByTitle(String categoryTitle) {
        driver.findElement(nameFilter).sendKeys(categoryTitle);
        driver.findElement(searchFilterButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetFilterButton));
    }
}
