package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import main.StolenValues;

import org.junit.Test;

public class StolenValuesTest {

  @Test
  public void test() {
    StolenValues sv = new StolenValues();
    List<Integer> list = new ArrayList<Integer>();
    list.add(6);
    list.add(1);
    list.add(2);
    list.add(7);
    Assert.assertEquals(13, sv.maxStolenAmount(list));
  }
}
