package Ogun_Framework.extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import java.lang.String;

@Extension
public class StringExtention {
  public static void helloWorld(@This String thiz) {
    System.out.println("hello world!");
  }
}