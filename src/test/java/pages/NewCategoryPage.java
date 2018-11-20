package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewCategoryPage extends BasePage {

    public static final By newCategoryTitle = By.id("name_1");
    public static final By submitAddCategoryButton = By.id("category_form_submit_btn");
    public static final By successfulCreatingMessage = By.xpath("//div[contains(@class, 'alert-success')][contains(., 'Создано')]");


    public static void fillCategoryTitle(String categoryTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCategoryTitle));
        driver.findElement(newCategoryTitle).sendKeys(categoryTitle);
    }

    public static void submitAddingCategory() {
        driver.findElement(submitAddCategoryButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulCreatingMessage));
    }
}
