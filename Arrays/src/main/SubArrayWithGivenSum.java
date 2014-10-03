package main;

public class SubArrayWithGivenSum {
  private final int[] array;
  private final int size;

  public static class SubArrayBoundary {
    public int start;
    public int end;
    public int sum;
  }

  public SubArrayWithGivenSum(int[] array, int size) {
    this.array = array;
    this.size = size;
  }

  public SubArrayBoundary getSubarray(int sum) {
    int currentSum = array[0];
    int start = 0;
    for (int i = 1; i <= size; i++) {
      while (currentSum > sum && start < i - 1) {
        currentSum = currentSum - array[start];
        start++;
      }
      if (currentSum == sum) {
        SubArrayBoundary sab = new SubArrayBoundary();
        sab.start = start;
        sab.end = i - 1;
        sab.sum = currentSum;
        return sab;
      }
      if (i < size) {
        currentSum += array[i];
      }
    }
    return null;
  }

}
