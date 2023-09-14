package enums;

import org.junit.Assert;

import static hooks.Hooks.commonPage;
import static hooks.Hooks.driver;

public enum EnumClass {
    // Java calismalari class'i incelendiginde sunu görebiliriz;
    // **NormalClass'in bilgilerini JavaCalismalari adli class'da kullanmak istedigimizde
    // NormalClass'dan bir obje oluturuyoruz.
    // **ENUM Class'larda ise obje, bilgilerin kullanilmak istedigi class'da degil,
    // yine ENUM Class'inin icinden olusturulur.
    // Tipki alt satirdaki gibi...
    HOMEPAGE("https://test.kesifplus.com/",0),
    ABOUT_US_PAGE("https://test.kesifplus.com/about-us",1),
    CONTACT_US_PAGE("https://test.kesifplus.com/contact-us",2),
    ;

    private String url;
    private int index;

    EnumClass(String url, int index) {
        this.url = url;
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public int getIndex() {
        return index;
    }

    public void assertUrl(){
        Assert.assertEquals(this.url,driver.getCurrentUrl());
    }

    public void clickPage(){

        commonPage.getHomePage().navbarlist.get(this.index).click();
    }
}
