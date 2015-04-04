package test;

import java.util.List;

import main.BinarySequenceGenerator;

import org.junit.Test;

public class BinarySequenceGeneratorTest {
  @Test
  public void test() {
    List<String> output = BinarySequenceGenerator.generate(3);
    for (String s : output) {
      System.out.println(s + " ");
    }
  }
}
