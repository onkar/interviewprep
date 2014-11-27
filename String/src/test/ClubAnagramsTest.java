package test;

import java.util.List;

import main.ClubAnagrams;

import org.junit.Test;

public class ClubAnagramsTest {
  @Test
  public void test() {
    String[] array = {"act", "jam", "cat", "onkar", "fruits", "dog", "apple", "god"};
    ClubAnagrams ca = new ClubAnagrams();
    List<String> result = ca.clubAnagrams(array);
    for (String r : result) {
      System.out.println(r);
    }
  }
}
