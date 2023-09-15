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
    }

    @Then("user should able to see  background color and text color are expected value")
    public void userShouldAbleToSeeBackgroundColorAndTextColorAreExpectedValue() {
    }

    public void scrollToWebElement(WebElement webElement){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }


    // 1. way throw exception
    // 2. way try/catch
    // 3. way lombok annotation @SneakyThrows
    @SneakyThrows
    public void waitFor(int sec) {
        //try-catch haricinde Java bize exception firlatmamizi da öneriyor
        // Ancak bu cok da istedigimiz bir yöntem degil cünkü throw exception yaptigimizda
        // bu methodu kullandigimiz her baska bir methodda da bizden exception firlatmamizi isteyecektir
        // try- catch burada daha iyi bir cözüm olacaktir

        //try {
            Thread.sleep(1000L *sec);  //eger bu satirda problem yoksa islemi yapiyor
       // } catch (InterruptedException e) {
        //    throw new RuntimeException(e);          // eger üst satirda problem varsa burayi yapiyor
        //}
       // finally {
       //     try icindeki islemde problem olsa da olmasa da buradaki islemi yapar
       // }
    }

        public void hoverWebElement(WebElement webElement){
            actions.moveToElement(webElement).build().perform();
            // Eger bir WebElement üzerinde Actions class'i yardimiyla birden fazla islem yapacaksak
            //.build().perform() yapmaliyiz. Eger tek bir islem yapacaksak sadece .perform() yeterli olacaktir.
        }
}
