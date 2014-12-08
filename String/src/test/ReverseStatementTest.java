package test;

import main.ReverseSentence;

import org.junit.Test;

public class ReverseStatementTest {
  @Test
  public void test() {
    String str = "The sky is blue";
    ReverseSentence rs = new ReverseSentence();
    System.out.println(rs.reverse(str));
    str = "The sky  is  blue ";
    System.out.println(rs.reverse(str));
  }
}
