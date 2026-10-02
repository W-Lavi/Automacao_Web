package Framework;

import Framework.Browser.Drivermanager;
import Framework.Browser.TypeBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TesteBase {
    private static final String URL = "https://www.saucedemo.com/";

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Drivermanager.getDriver(TypeBrowser.CHROME);
        driver.get(URL);
    }

    @AfterEach
    public void finish() {
        Drivermanager.quitDriver();
    }
}