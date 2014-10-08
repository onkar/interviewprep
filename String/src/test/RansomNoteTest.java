package test;

import junit.framework.Assert;
import main.RansomNote;

import org.junit.Test;

public class RansomNoteTest {
  private RansomNote rn;

  @Test
  public void test() {
    rn = new RansomNote("I think this will kill you", "I will kill you");
    Assert.assertTrue(rn.isRansomFromMagazine());

    rn = new RansomNote("I think this will kill you", "Blah blah! will kill you");
    Assert.assertFalse(rn.isRansomFromMagazine());

    rn = new RansomNote("I think this will kill you", "Kill you");
    Assert.assertFalse(rn.isRansomFromMagazine());
  }

}
