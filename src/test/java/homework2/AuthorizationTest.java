package homework2;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationTest {

    static String baseUrl = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    static String username = "webinar.test@gmail.com";
    static String password = "Xcg7299bnSmMuRLp9ITw";

    public static void main(String[] args) throws InterruptedException {

        By emailField = By.id("email");
        By passwordField = By.id("passwd");
        By submitButton = By.name("submitLogin");
        By smallAvatar = By.className("employee_avatar_small");
        By logoutLink = By.id("header_logout");

        WebDriver driver = DriverManager.getDriver("chrome");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.manage().window().maximize();
            driver.get(baseUrl);

            //login
            driver.findElement(emailField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(submitButton).click();
            //logout
            wait.until(ExpectedConditions.visibilityOfElementLocated(smallAvatar));
            driver.findElement(smallAvatar).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
            driver.findElement(logoutLink).click();
        } finally {
            driver.quit();
        }
    }

}
