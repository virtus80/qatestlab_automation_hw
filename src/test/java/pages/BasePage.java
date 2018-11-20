package pages;

import homework2.TestBase;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static EventFiringWebDriver driver = TestBase.driver;
    public static WebDriverWait wait = TestBase.wait;

}
