package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login");

    public void login(String user, String pass) {
        WaitUtils.waitForElementVisible(driver, username, 10).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
