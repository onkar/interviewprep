package test;

import java.util.ArrayList;

import main.Triangles;

import org.junit.Assert;
import org.junit.Test;

public class TrianglesTest {
  @Test
  public void test() {
    int[] input = {5, 4, 6, 9};
    ArrayList<ArrayList<Integer>> result = Triangles.get(input);
    Assert.assertEquals(3, result.size());

    Assert.assertEquals(result.get(0).get(0).intValue(), 4);
    Assert.assertEquals(result.get(0).get(1).intValue(), 5);
    Assert.assertEquals(result.get(0).get(2).intValue(), 6);

    Assert.assertEquals(result.get(1).get(0).intValue(), 4);
    Assert.assertEquals(result.get(1).get(1).intValue(), 6);
    Assert.assertEquals(result.get(1).get(2).intValue(), 9);

    Assert.assertEquals(result.get(2).get(0).intValue(), 5);
    Assert.assertEquals(result.get(2).get(1).intValue(), 6);
    Assert.assertEquals(result.get(2).get(2).intValue(), 9);
  }
}
