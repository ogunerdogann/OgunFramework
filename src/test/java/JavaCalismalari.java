import enums.EnumClass;
import enums.NormalClass;
import org.junit.Test;

public class JavaCalismalari {

    @Test
    public void enumCalismalari(){

        //way 1 class kullanimi
        NormalClass normalClass = new NormalClass("https://test.kesifplus.com/",0);
        normalClass.assertUrl();

        // way 2 enum class kullanimi
        EnumClass.HOMEPAGE.assertUrl();
        System.out.println(EnumClass.HOMEPAGE.getUrl());


    }
}
