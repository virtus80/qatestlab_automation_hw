package homework2;

import drivers.DriverManager;
import drivers.WebDriverLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public static EventFiringWebDriver driver;
    public static WebDriverWait wait;
    public static String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";

    static By emailField = By.id("email");
    static By passwordField = By.id("passwd");
    static By submitButton = By.name("submitLogin");


    public static void loginAs(String username, String password) {
        driver.findElement(emailField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public static void initDriver(String browser) {
        driver = new EventFiringWebDriver(DriverManager.getDriver(browser));
        driver.register(new WebDriverLogger());
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    public static void openStartPage() {
        driver.get(baseUrl);
    }

    public static void stopDriver() {
        driver.quit();
    }
}
