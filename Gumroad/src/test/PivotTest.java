package test;

import main.Pivot;

import org.junit.Assert;
import org.junit.Test;

public class PivotTest {
  @Test
  public void testPivot() {
    // 1. Find single pivot correctly
    int[] singlePivot = {1, 4, 6, 3, 2};
    Assert.assertEquals(2, Pivot.getPivot(singlePivot));

    // 2. Return -1 if no pivot is found
    int[] noPivot = {1, 2, 3, 4};
    Assert.assertEquals(-1, Pivot.getPivot(noPivot));

    // 3. In case of multiple pivots, return the leftmost pivot. Note that there are two pivots
    // (index = 3 and index = 6).
    int[] multiplePivots = {-7, 1, 5, 2, -4, 3, 0};
    Assert.assertEquals(3, Pivot.getPivot(multiplePivots));

    // 4. Return -1 if there is only one element in the array.
    int[] singleElement = {1};
    Assert.assertEquals(-1, Pivot.getPivot(singleElement));

    // 5. Return -1 if there is no element in the array.
    int[] zeroElement = {};
    Assert.assertEquals(-1, Pivot.getPivot(zeroElement));

    // 6. Return correct index if biggest element is the last element of the array
    int[] biggestElementLast = {66, 32, 1, 0, 99};
    Assert.assertEquals(3, Pivot.getPivot(biggestElementLast));

    // 7. Return correct index if biggest element is the first element of the array
    int[] biggestElementFirst = {99, 0, 66, 32, 1};
    Assert.assertEquals(1, Pivot.getPivot(biggestElementFirst));
  }
}
