package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import drivers.DriverManager;

import java.util.List;


public class MainMenuTest {

    static String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    static String username = "webinar.test@gmail.com";
    static String password = "Xcg7299bnSmMuRLp9ITw";

    static WebDriver driver = DriverManager.getDriver("chrome");
    static WebDriverWait wait = new WebDriverWait(driver, 10);

    public static void main(String[] args) {

        By emailField = By.id("email");
        By passwordField = By.id("passwd");
        By submitButton = By.name("submitLogin");
        By mainMenuItems = By.cssSelector("li.maintab");
//        By dashboardItem = By.linkText("Dashboard");
//        By ordersItem = By.linkText("Заказы");
//        By catalogItem = By.linkText("Каталог");
//        By clientsItem = By.linkText("Клиенты");
//        By supportItem = By.linkText("Служба поддержки");
//        By statisticsItem = By.linkText("Статистика");
//        By modulesItem = By.linkText("Modules");
//        By designItem = By.linkText("Design");
//        By carrierItem = By.linkText("Доставка");
//        By paymentItem = By.linkText("Способ оплаты");
//        By localizationItem = By.linkText("International");
//        By preferencesItem = By.linkText("Shop Parameters");
//        By configurationItem = By.linkText("Конфигурация");

        try {
            driver.manage().window().maximize();
            driver.get(baseUrl);

            //login
            driver.findElement(emailField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(submitButton).click();
            // check page titles for main menu items
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mainMenuItems));
            List<WebElement> menuItems = driver.findElements(mainMenuItems);
            for (int i = 0; i < menuItems.size(); i++) {
                WebElement item = menuItems.get(i);
                checkPageTitle(item);
                //workaround for catalog and modules pages because locators are changed on it
                if(i == 2 || i == 6) {
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li.link-levelone")));
                    menuItems = driver.findElements(By.cssSelector("li.link-levelone"));
                } else {
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mainMenuItems));
                    menuItems = driver.findElements(mainMenuItems);
                }
            }
        } finally {
            driver.quit();
        }
    }

    private static void checkPageTitle(WebElement dashboardItem) {
        By pageTitle = By.tagName("h2");
        wait.until(ExpectedConditions.visibilityOf(dashboardItem));
        dashboardItem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        String titleBeforeRefreshing = driver.findElement(pageTitle).getText();
        System.out.println("Title of current page: " + titleBeforeRefreshing);
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        String titleAfterRefreshing = driver.findElement(pageTitle).getText();
        System.out.println("Title of current page: " + titleAfterRefreshing);
        assert titleBeforeRefreshing.equals(titleAfterRefreshing);
    }

}
