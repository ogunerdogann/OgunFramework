package step_definitions;

import io.cucumber.java.en.Given;
import pages.CommonPage;
import utilities.ConfigurationReader;

import static hooks.Hooks.*;



public class US_16_SD extends CommonPage {

    @Given("User goes to HomePage")
    public void userGoesToHomePage() {
            driver.get(ConfigurationReader.getProperty("KesifPlusUrl"));
            getHomePage().kontrol();
    }

}
