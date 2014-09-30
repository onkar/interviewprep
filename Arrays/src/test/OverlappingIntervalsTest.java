package test;

import java.util.List;

import junit.framework.Assert;
import main.OverlappingIntervals;
import main.OverlappingIntervals.TimeFrame;

import org.junit.Test;

public class OverlappingIntervalsTest {
  private OverlappingIntervals oli;

  @Test
  public void test() {
    oli = new OverlappingIntervals();
    List<TimeFrame> result = oli.mergedIntervals();
    Assert.assertEquals(2, result.size());
    Assert.assertEquals(1, result.get(0).startTime);
    Assert.assertEquals(4, result.get(0).endTime);
    Assert.assertEquals(5, result.get(1).startTime);
    Assert.assertEquals(8, result.get(1).endTime);
  }
}
