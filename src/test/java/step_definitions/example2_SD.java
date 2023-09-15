package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static hooks.Hooks.driver;

public class example2_SD {

    @When("user scroll the plan and pricing")
    public void userScrollThePlanAndPricing() {
    }

    @Then("user should able to see silver backround color and text color are expected value")
    public void userShouldAbleToSeeSilverBackroundColorAndTextColorAreExpectedValue() {
    }

    @Then("user should able to see gold backround color and text color are expected value")
    public void userShouldAbleToSeeGoldBackroundColorAndTextColorAreExpectedValue() {
    }

    @Then("user should able to see  backround color and text color are expected value")
    public void userShouldAbleToSeeBackroundColorAndTextColorAreExpectedValue() {
    }

    public void scrollToWebElement(WebElement webElement){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }


    // 1. way throw exception
    // 2. way try/catch

    public void waitFor(int sec) {
        //try-catch haricinde Java bize exception firlatmamizi da öneriyor
        // Ancak bu cok da istedigimiz bir yöntem degil cünkü throw exception yaptigimizda
        // bu methodu kullandigimiz her baska bir methodda da bizden exception firlatmamizi isteyecektir
        // try- catch burada daha iyi bir cözüm olacaktir

        try {
            Thread.sleep(Duration.ofSeconds(sec));  //eger bu satirda problem yoksa islemi yapiyor
        } catch (InterruptedException e) {
            throw new RuntimeException(e);          // eger üst satirda problem varsa burayi yapiyor
        }
       // finally {
       //     try icindeki islemde problem olsa da olmasa da buradaki islemi yapar
       // }
    }


}
