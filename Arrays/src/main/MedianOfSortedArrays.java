package main;

import java.util.Arrays;

public class MedianOfSortedArrays {
  public int getMedian(int[] array1, int[] array2) {
    return getMedian(array1, array1.length, array2, array2.length);
  }

  private int getMedian(int[] array1, int n1, int[] array2, int n2) {
    if (n1 == 1 && n2 == 1)
      return (array1[0] + array2[0]) / 2;
    if (n1 == 2 && n2 == 2)
      return (Math.max(array1[0], array2[0]) + Math.min(array1[1], array2[1])) / 2;
    int m1 = median(array1);
    int m2 = median(array2);
    if (m1 == m2) {
      return m1;
    } else if (m1 < m2) {
      int[] part1;
      int[] part2;
      if (n1 % 2 == 0)
        part1 = Arrays.copyOfRange(array1, n1 / 2 - 1, n1);
      else
        part1 = Arrays.copyOfRange(array1, n1 / 2, n1);

      if (n2 % 2 == 0)
        part2 = Arrays.copyOfRange(array2, 0, n2 / 2 - 1);
      else
        part2 = Arrays.copyOfRange(array2, 0, n2 / 2);
      return getMedian(part1, part1.length, part2, part2.length);
    } else {
      int[] part1;
      int[] part2;
      if (n1 % 2 == 0)
        part1 = Arrays.copyOfRange(array1, 0, n1 / 2 - 1);
      else
        part1 = Arrays.copyOfRange(array1, 0, n1 / 2);
      if (n2 % 2 == 0)
        part2 = Arrays.copyOfRange(array2, n2 / 2 - 1, n2);
      else
        part2 = Arrays.copyOfRange(array2, n2 / 2, n2);
      return getMedian(part1, part1.length, part2, part2.length);
    }

  }

  int median(int[] a) {
    int n = a.length;
    if (n % 2 == 0) {
      return (a[n / 2] + a[n / 2 - 1]) / 2;
    } else {
      return a[n / 2];
    }
  }
}
