package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class US45_SD {
    HomePage homePage = new HomePage();
    Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String email = "ogn.deneme@ogn.com";


    List<String> coursesDB = new ArrayList<>();

    @Given("login account page")
    public void loginAccountPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("KesifPlusUrl"));
    }

    @When("Login Account text is visible")
    public void loginAccountTextIsVisible() {
        Assert.assertTrue(homePage.loginAccountText.isDisplayed());
    }

    @Then("enter username")
    public void enterUsername() {
        homePage.eMailTextBox.click();
        homePage.eMailTextBox.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @Then("enter password")
    public void enterPassword() {
        homePage.passwordTextBox.click();
        homePage.passwordTextBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("click on login button")
    public void clickOnLoginButton() {
        try {
            ReusableMethods.scrollToElement(Driver.getDriver(), homePage.loginButton);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.loginButton.click();
    }

    @Then("click on programs button on side bar")
    public void clickOnProgramsButtonOnSideBar() {
        homePage.programsButton.click();
    }

    @And("verify courses")
    public void verifyCourses() {
        homePage.kontrol();
    }

    @Given("connect with database")
    public void connectWithDatabase() {
        // getConnection hata gösteriyor try-catch ile cevrele
        try {
            connection = DriverManager.getConnection("jdbc:mysql://test.kesifplus.com:3306/kesifplus",
                    "root",
                    "cMk76oD4Z9dP");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("execute a query")
    public void executeAQuery() {
        boolean flag = false;
        // Buradaki komutlar da hata verecek, try-catch kullan!
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `courses`");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while(resultSet.next()){  //DB'de kac kayit var bilmiyoruz. Next olmadigi duruma kadar gidecek
                System.out.println("resultSet.getString(\"course_text_title\") = " + resultSet.getString("course_text_title"));
                coursesDB.add(resultSet.getString("course_text_title"));
                // SQL'de indexlerimiz HER ZAMAN 1'den BASLAR!!!


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Test Gecti");
        for (int i = 0; i < homePage.coursesUI.size(); i++) {

            Assert.assertTrue(coursesDB.contains(homePage.coursesUI.get(i)));

        }
    }


    @Then("make assertions")
    public void makeAssertions() {

    }
}
