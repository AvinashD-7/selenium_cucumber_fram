package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("user is on login page")
    public void userOnLoginPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"),
                "Expected to be on login page, but was: " + currentUrl);
    }

    @When("user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should be logged in")
    public void userShouldBeLoggedIn() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/dashboard"),
                "Expected to be on dashboard page, but was: " + currentUrl);

        boolean isWelcomeVisible = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
        Assert.assertTrue(isWelcomeVisible, "Dashboard message not visible after login.");
    }

    @Then("user should be {string}")
    public void user_should_be(String expectedStatus) {
        loginPage.verifyLoginStatus(expectedStatus);
    }
}
