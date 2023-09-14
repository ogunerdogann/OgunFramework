package step_definitions;

import enums.EnumClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import pages.HomePage;
import utilities.BrowserUtilities;

import static hooks.Hooks.commonPage;
import static hooks.Hooks.driver;

public class example1_SD extends CommonPage {

    HomePage homePage = new HomePage();
    @Given("users goes to homepage")
    public void usersGoesToHomepage() {
        driver.get("https://test.kesifplus.com/");
    }

    @When("user clicks on home button")
    public void userClicksOnHomeButton() {

        //way 1 -->Single WebElement üzerinden getirdik
        // homePage.homeButton.click();

        //way 2 -->List üzerinden getirdik
        //homePage.navbarlist.get(0).click();

        //way3 --> CommonPage'deki objeyi kullandik
        //commonPage.getHomePage().homeButton.click();

        //way4 -->extends CommonPage
        getHomePage().navbarlist.get(0).click();
    }

    @Then("verify url is {string}")
    public void verifyUrlIs(String expectedUrl) {
        // way 1 simple assertion
        //Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

        //way 2 hazir method kullanma
        //assertUrl(expectedUrl);

        // way 3 browser utilities
        BrowserUtilities.assertUrl(expectedUrl);
    }

    @When("user clicks on about us button")
    public void userClicksOnAboutUsButton() {
        homePage.navbarlist.get(1).click();
    }

    public void assertUrl(String expectedUrl){
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }


    @Then("assert with enum")
    public void assertWithEnum() {
        EnumClass.HOMEPAGE.assertUrl();

        EnumClass.ABOUT_US_PAGE.clickPage();
        EnumClass.ABOUT_US_PAGE.assertUrl();

        EnumClass.CONTACT_US_PAGE.clickPage();
        EnumClass.CONTACT_US_PAGE.assertUrl();
    }
}
