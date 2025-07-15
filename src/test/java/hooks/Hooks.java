package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setup() {
        // You can make this configurable via config file
        driver = DriverFactory.initDriver("chrome"); // or "firefox"
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
    }
}
