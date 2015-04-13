package test;

import main.Parantheses;

import org.junit.Test;

public class ParanthesesTest {
  @Test
  public void test() {
    System.out.println(Parantheses.generate(3));
    System.out.println(Parantheses.generateBetter(3));
  }
}
