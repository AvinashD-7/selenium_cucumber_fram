package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void userOnLoginPage() {
        DriverFactory.getDriver().get("https://example.com/login");
    }

    @When("user enters username {string} and password {string}")
    public void userEntersCredentials(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Then("user should be logged in")
    public void userShouldBeLoggedIn() {
        // validation logic here
    }
}
