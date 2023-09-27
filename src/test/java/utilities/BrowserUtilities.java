package utilities;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static hooks.Hooks.actions;
import static hooks.Hooks.driver;

public class BrowserUtilities {

    public static void assertUrl(String expectedUrl){
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }

    public static void scrollToWebElement(WebElement webElement){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }


    // 1. way throw exception
    // 2. way try/catch
    // 3. way lombok annotation @SneakyThrows
    @SneakyThrows
    public static void waitFor(int sec) {
        //try-catch haricinde Java bize exception firlatmamizi da öneriyor
        // Ancak bu cok da istedigimiz bir yöntem degil cünkü throw exception yaptigimizda
        // bu methodu kullandigimiz her baska bir methodda da bizden exception firlatmamizi isteyecektir
        // try- catch burada daha iyi bir cözüm olacaktir

        try {
        Thread.sleep(1000 *sec);  //eger bu satirda problem yoksa islemi yapiyor
         } catch (InterruptedException e) {
            throw new RuntimeException(e);          // eger üst satirda problem varsa burayi yapiyor
        }
        // finally {
        //     try icindeki islemde problem olsa da olmasa da buradaki islemi yapar
        // }
    }

    public static void hoverWebElement(WebElement webElement){
        actions.moveToElement(webElement).build().perform();
        // Eger bir WebElement üzerinde Actions class'i yardimiyla birden fazla islem yapacaksak
        //.build().perform() yapmaliyiz. Eger tek bir islem yapacaksak sadece .perform() yeterli olacaktir.
    }

    public static void assertTextColorOfWebElement(String rgba, WebElement webElement) {
        Assert.assertEquals(rgba,webElement.getCssValue("color"));
    }

    /**
     * JavaDoc WebElementin background color'ini assert ediyoruz
     * @param rgba webelementin background rengi
     * @param webElement rengini alacagimiz webelement
     * @author OgünErd
     * @since 08.08.2023
     */
    public static void assertBackgroundOfWebElement(String rgba, WebElement webElement) {
        Assert.assertEquals(rgba,webElement.getCssValue("background-color"));
    }
}
