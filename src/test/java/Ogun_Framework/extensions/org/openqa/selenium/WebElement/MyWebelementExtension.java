package Ogun_Framework.extensions.org.openqa.selenium.WebElement;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

@Extension
public class MyWebelementExtension {
  public static void assertTextColor(@This WebElement thiz, String rgba) {
    Assert.assertEquals(rgba,thiz.getCssValue("color"));
  }
  public static void assertBackGroundColor(@This WebElement thiz, String rgba) {
    Assert.assertEquals(rgba,thiz.getCssValue("background-color"));
  }
}