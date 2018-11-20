package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public static final By emailField = By.id("email");
    public static final By passwordField = By.id("passwd");
    public static final By submitButton = By.name("submitLogin");

    public static void loginAs(String username, String password) {
        driver.findElement(emailField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}
