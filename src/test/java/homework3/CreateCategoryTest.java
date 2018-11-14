package homework3;

import homework2.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateCategoryTest extends TestBase {

    static By catalogItem = By.linkText("Каталог");
    static By categoriesSubitem = By.id("subtab-AdminCategories");
    static By addNewCategoryButton = By.id("page-header-desc-category-new_category");
    static By newCategoryTitle = By.id("name_1");
    static By submitAddCategoryButton = By.id("category_form_submit_btn");
    static By successfulCreatingMessage = By.xpath("//div[contains(@class, 'alert-success')][contains(., 'Создано')]");
    static By nameFilter = By.name("categoryFilter_name");
    static By resetFilterButton = By.name("submitResetcategory");
    static By searchFilterButton = By.id("submitFilterButtoncategory");
    static By nameCategoryCell = By.cssSelector("#table-category tbody td:nth-of-type(3)");

    public static void main(String[] args) {

        try {
            initDriver("chrome");
            openStartPage();
            loginAs("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
            gotoCategoriesPage();
            initAddingCategory();
            String categoryTitle = "testCategory_" + (int)(Math.random()*10000);
            fillCategoryTitle(categoryTitle);
            submitAddingCategory();
            searchByTitle(categoryTitle);
            wait.until(ExpectedConditions.attributeContains(driver.findElement(nameCategoryCell),
                    "textContent", categoryTitle));
        } finally {
            stopDriver();
        }

    }

    private static void gotoCategoriesPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogItem));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(catalogItem)).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSubitem));
        driver.findElement(categoriesSubitem).click();
    }

    private static void initAddingCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addNewCategoryButton));
        driver.findElement(addNewCategoryButton).click();
    }


    private static void fillCategoryTitle(String categoryTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCategoryTitle));
        driver.findElement(newCategoryTitle).sendKeys(categoryTitle);
    }

    private static void submitAddingCategory() {
        driver.findElement(submitAddCategoryButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulCreatingMessage));
    }

    private static void searchByTitle(String categoryTitle) {
        driver.findElement(nameFilter).sendKeys(categoryTitle);
        driver.findElement(searchFilterButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetFilterButton));
    }

}
