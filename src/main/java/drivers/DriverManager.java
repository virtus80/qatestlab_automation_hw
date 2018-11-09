package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverManager {

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", new File(DriverManager.class.getResource("/geckodriver.exe")
                        .getFile()).getPath());
                return new FirefoxDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", new File(DriverManager.class.getResource("/chromedriver.exe")
                        .getFile()).getPath());
                return new ChromeDriver();
        }
    }

}
