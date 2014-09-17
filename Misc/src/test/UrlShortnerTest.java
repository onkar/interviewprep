package test;

import junit.framework.Assert;
import main.UrlShortner;

import org.junit.Test;

public class UrlShortnerTest {
  int autoincrementingId = 125;
  String baseUrl = "http://short.ly/";

  @Test
  public void test() {
    String str = UrlShortner.encode(autoincrementingId);
    System.out.println(baseUrl + str);
    int num = UrlShortner.decode(str);
    System.out.println(num);
    Assert.assertEquals(autoincrementingId, num);
  }
}
