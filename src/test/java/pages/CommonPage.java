package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class CommonPage {

    public CommonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    private HomePage homePage;
    private LoginPage loginPage;

    //Üst satirda tanimladigimiz objeler private oldugu icin bu objeleri cagirmak istedigimizde getter'lari kullaniyoruz.
    //Baska class'larda bu getter sayesinde HomePage ve LoginPage objelerine ulasabilecegiz

    public  HomePage getHomePage() {
        if (homePage == null){   // bos ise icini doldur getir, ici dolu ise direk getir
            homePage = new HomePage(); //böylece biz cagirmadigimiz sürece obje olusmayacak ve Heap Memory'i sisirmeyecegiz
        } // Eger objeji en yukarida tanimlayip deger atasaydik (private HomePage homePage = new HomePage();)
        // O zaman kullanmadigimiz zamanlarda bile objeyi olusturup icini dolduracakti. Gereksiz hafiza kullanimi olurdu bu.
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
}
