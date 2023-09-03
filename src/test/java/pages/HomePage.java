package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage  extends CommonPage {


    @FindBy(css = "li>a[href^='/']")
    private static List<WebElement> navbarList;

    @FindBy(css = "li>a[href^='/']")
    public List<WebElement> navbarList1;

    @FindBy(css = "li>a[href^='/']")
    public static List<WebElement> navbarList2;

    public static void kontrol(){
        for (int i = 0; i < navbarList.size(); i++) {
            System.out.println(navbarList.get(i).getText().toString());
        }
    }


}
