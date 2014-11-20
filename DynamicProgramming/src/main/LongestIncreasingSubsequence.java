package main;


/**
 * Let arr[0..n-1] be the input array and L(i) be the length of the LIS till index i such that
 * arr[i] is part of LIS and arr[i] is the last element in LIS, then L(i) can be recursively written
 * as. L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there is no such j then
 * L(i) = 1 To get LIS of a given array, we need to return max(L(i)) where 0 < i < n
 * 
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33,
 * 50, 60, 80}.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class LongestIncreasingSubsequence {
  public int getLISLength(int[] input) {
    int[] lis = new int[input.length];
    for (int i = 0; i < lis.length; i++) {
      lis[i] = 1;
    }
    for (int i = 1; i < input.length; i++) {
      for (int j = 0; j < i; j++) {
        if (input[i] > input[j] && lis[i] < lis[j] + 1) {
          lis[i] = lis[j] + 1;
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < lis.length; i++) {
      if (max < lis[i]) {
        max = lis[i];
      }
    }
    return max;
  }
}
