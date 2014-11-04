package test;

import main.EditDistance;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest {
  @Test
  public void test() {
    String str1 = "Saturday";
    String str2 = "Sunday";
    EditDistance ed = new EditDistance();
    Assert.assertEquals(3, ed.getMinEdits(str1, str2));
    str1 = "trials";
    str2 = "zeil";
    Assert.assertEquals(4, ed.getMinEdits(str1, str2));
  }
}
