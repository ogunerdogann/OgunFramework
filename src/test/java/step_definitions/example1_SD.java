package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static hooks.Hooks.driver;

public class example1_SD {
    @Given("users goes to homepage")
    public void usersGoesToHomepage() {
        driver.get("https://test.kesifplus.com/");
    }

    @When("user clicks on home button")
    public void userClicksOnHomeButton() {
    }

    @Then("verify url is {string}")
    public void verifyUrlIs(String arg0) {
    }

    @When("user clicks on about us button")
    public void userClicksOnAboutUsButton() {
    }
}
