package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class CommonPage {

    public CommonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    private HomePage homePage;
    private LoginPage loginPage;


    public  HomePage getHomePage() {
        if (homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
