package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationTest extends TestBase {

    public static void main(String[] args) throws InterruptedException {

        By smallAvatar = By.className("employee_avatar_small");
        By logoutLink = By.id("header_logout");

        try {
            initDriver("chrome");
            openStartPage();
            loginAs("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
            //logout
            wait.until(ExpectedConditions.visibilityOfElementLocated(smallAvatar));
            driver.findElement(smallAvatar).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
            driver.findElement(logoutLink).click();
        } finally {
            stopDriver();
        }
    }

}
