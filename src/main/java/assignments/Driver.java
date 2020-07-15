package assignments;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setWebDriver(WebDriver driverParam) {

        driver.set(driverParam); 
    }

    public static WebDriver getWebDriver() {
        return driver.get();
    }
}
