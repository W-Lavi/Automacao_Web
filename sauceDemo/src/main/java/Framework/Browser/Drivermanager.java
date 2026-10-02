package Framework.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivermanager {
    private static WebDriver driver;

    private static WebDriver getManagerDrive(TypeBrowser type) {
        switch (type) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
                return new ChromeDriver(chromeOptions);

            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--inprivate");
                return new EdgeDriver(edgeOptions);

            case FIREFOX:
                return new FirefoxDriver();

            case HEADLESS:
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("--headless=new");
                headlessOptions.addArguments("--window-size=1366,768");
                return new ChromeDriver(headlessOptions);

            default:
                throw new IllegalArgumentException("Navegador não suportado: " + type);
        }
    }

    public static WebDriver getDriver(TypeBrowser type) {
        if (driver == null) {
            driver = getManagerDrive(type);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}