package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.conFigReader;

import java.util.List;

public class DashBoardSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    DashBoardPage dashboardPage = new DashBoardPage(driver);

    @Given("the user has logged in successfully")
    public void the_user_has_logged_in_successfully() {
        // No need for driver.get() here — Hooks.java already navigates to base.url
        String username = conFigReader.get("username");
        String password = conFigReader.get("password");

        loginPage.login(username, password);
    }

    @Then("the dashboard should display the following sections:")
    public void the_dashboard_should_display_the_following_sections(List<String> expectedSections) {
        for (String expectedSection : expectedSections) {
            String actualSection = dashboardPage.getSectionText(expectedSection);
            DashBoardPage.verifySectionText(actualSection, expectedSection);
        }
    }
}
