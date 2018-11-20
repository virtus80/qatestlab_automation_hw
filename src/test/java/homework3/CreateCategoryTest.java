package homework3;

import homework2.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CategoryPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewCategoryPage;

public class CreateCategoryTest extends TestBase {

    public static void main(String[] args) {

        try {
            initDriver("chrome");
            openStartPage();
            LoginPage.loginAs("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
            DashboardPage.gotoCategoriesPage();
            CategoryPage.initAddingCategory();
            String categoryTitle = "testCategory_" + (int)(Math.random()*10000);
            NewCategoryPage.fillCategoryTitle(categoryTitle);
            NewCategoryPage.submitAddingCategory();
            CategoryPage.searchByTitle(categoryTitle);
            wait.until(ExpectedConditions.attributeContains(driver.findElement(CategoryPage.nameCategoryCell),
                    "textContent", categoryTitle));
        } finally {
            stopDriver();
        }
    }










}
