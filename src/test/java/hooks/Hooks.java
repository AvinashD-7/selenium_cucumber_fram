package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.conFigReader;

public class Hooks {


    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.get(conFigReader.get("base.url"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
