package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

import static hooks.Hooks.*;
import static utilities.BrowserUtilities.*;

public class example2_SD {

    @When("user scroll the plan and pricing")
    public void userScrollThePlanAndPricing() {
        scrollToWebElement(commonPage.getHomePage().planAndPricingText);
        waitFor(2);
    }

    @Then("user should able to see silver background color and text color are expected value")
    public void userShouldAbleToSeeSilverBackgroundColorAndTextColorAreExpectedValue() {
        System.out.println(commonPage.getHomePage().silver_getStarted.getCssValue("background-color"));
        System.out.println(commonPage.getHomePage().silver_getStarted.getCssValue("color"));
        // Web sitesinde herhangi bir WebElementin rengi, arkaplan rengi, yazi boyutu vs. gibi
        // bircok özelligi .getCssValue komutu ile getirebiliyoruz.
        // Bu özellikleri web sitesinde görmek icin ise inspect yaptiktan sonra sag kisimda
        // Elements ve onun da alt kismindaki Component veya Style (component daha sade görünüme sahip)
        //  sekmesinden görebiliyoruz

        // WAY 1
        Assert.assertEquals(
                "rgba(245, 245, 250, 1)",
                commonPage.getHomePage().silver_getStarted.getCssValue("background-color"));
        Assert.assertEquals(
                "rgba(23, 150, 95, 1)",
                commonPage.getHomePage().silver_getStarted.getCssValue("color"));

        // imlecle üzerine geldikten sonra arka plan rengi nasil degisiyor
        hoverWebElement(commonPage.getHomePage().silver_getStarted);
        waitFor(1);
        Assert.assertEquals("rgba(23, 150, 95, 1)",
                 commonPage.getHomePage().silver_getStarted.getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",
                commonPage.getHomePage().silver_getStarted.getCssValue("color"));

    }

    @Then("user should able to see gold background color and text color are expected value")
    public void userShouldAbleToSeeGoldBackgroundColorAndTextColorAreExpectedValue() {

        //background-color degerini yazdiriyoruz
        System.out.println("commonPage.getHomePage().gold_getStarted.getCssValue(\"background-color\") = "
                + commonPage.getHomePage().gold_getStarted.getCssValue("background-color"));

        //color degerini yazdiriyoruz
        System.out.println("commonPage.getHomePage().gold_getStarted.getCssValue(\"color\") = "
                + commonPage.getHomePage().gold_getStarted.getCssValue("color"));

        //Burada yaptigimiz assert islemlerini method haline getirdik.
        // Method'u sec --> sag tikla --> refactor --> extract method
        //hazirladigimiz methodu ise Browser Utilities Class'inin icine koyduk

        //WAY 2 Method olusturma
        assertBackgroundOfWebElement("rgba(23, 150, 95, 1)",commonPage.getHomePage().gold_getStarted);
        assertTextColorOfWebElement("rgba(255, 255, 255, 1)",commonPage.getHomePage().gold_getStarted);

        // imlecle üzerine geldikten sonra arka plan rengi nasil degisiyor
        hoverWebElement(commonPage.getHomePage().silver_getStarted);
        waitFor(1);

        // WAY 3 Extension Class
        commonPage.getHomePage().gold_getStarted.assertTextColor("rgba(23, 150, 95, 1)");
        commonPage.getHomePage().gold_getStarted.assertBackGroundColor("rgba(255, 255, 255, 1)");

    }





    @Then("user should able to see  background color and text color are expected value")
    public void userShouldAbleToSeeBackgroundColorAndTextColorAreExpectedValue() {
    }

}
