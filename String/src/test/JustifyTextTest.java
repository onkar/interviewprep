package test;

import main.JustifyText;

import org.junit.Test;

public class JustifyTextTest {
  @Test
  public void test() {
    String s = "This is an example of text justification";
    System.out.println(JustifyText.justify(s, 50));
  }
}
