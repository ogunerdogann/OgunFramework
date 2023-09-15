package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage  extends CommonPage {

    public List<String> coursesUI= new ArrayList<>();

    @FindBy(css = "li a[href^='/']")
    public List<WebElement> navbarlist;

    //Home button
    @FindBy(xpath = "//*[text()='Home']")
    public WebElement homeButton;

    //About us button
    @FindBy(xpath = "//*[text()='About Us']")
    public WebElement aboutUsButton;

    // Programs Button side bar
    @FindBy(xpath = "//*[text()='Programs']")
    public  WebElement programsButton;

    // Login Account Text
    @FindBy(xpath = "//*[text()='Login Account']")
    public  WebElement loginAccountText;

    @FindBy(id = "email-uniq")
    public WebElement eMailTextBox;

    @FindBy(id = "password-uniq")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginButton;

    @FindBy(css = "section>div[class^='user-course']")
    public List<WebElement> courses;

    @FindBy(css = "div.package1 button")
    public WebElement silver_getStarted;

    @FindBy(css = "div.package2 button")
    public WebElement gold_getStarted;

    @FindBy(css = "div.package3 button")
    public WebElement platin_getStarted;

    @FindBy(css = "h4.pricing-h4")
    public WebElement planAndPricingText;



    public void kontrol(){
        for (int i = 0; i < courses.size(); i++) {
            coursesUI.add(i,courses.get(i).getText().toString().substring(0,courses.get(i).getText().toString().indexOf(" ")));
            System.out.println("coursesUI.get(i).toString() = " + coursesUI.get(i).toString());
            // System.out.println(courses.get(i).getText().toString().substring(0,courses.get(i).getText().toString().indexOf(" ")));
            Assert.assertTrue(courses.get(i).isDisplayed());
        }
    }



}
