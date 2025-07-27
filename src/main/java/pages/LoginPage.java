package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.WaitUtils;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // WebElements using @FindBy
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement invalidcredentials;

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    private WebElement dashboard;

    // Login method
    public void login(String user, String pass) {
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        loginButton.click();
    }

    public void verifyLoginStatus(String expectedStatus){
        if (expectedStatus.equals("logged in")) {
            // Your existing success check
            WaitUtils.waitForElementVisible(driver,dashboard ,5);
            String currentUrl = driver.getCurrentUrl();

            Assert.assertTrue(currentUrl.contains("/dashboard"),
                    "Expected to be on dashboard page, but was: " + currentUrl);
        } else if (expectedStatus.equals("not logged in")) {
            // Basic check for failed login (e.g. error message appears or URL doesn't change)
            boolean isErrorVisible = invalidcredentials.isDisplayed();
            Assert.assertTrue(isErrorVisible, "Expected error message not shown on failed login.");
        } else {
            throw new IllegalArgumentException("Unknown login result: " + expectedStatus);
        }
    }
}
