package main;

public class CycleInTheArray {
  /**
   * Given an array of integers where each element points to the index of the next element how would
   * you detect if there is a cycle in this array Note: if the element of array is in range[0, n-1],
   * where n is the length of array, then there must be at least one cycle. Thus, the element may be
   * negative or out of range[0,n-1]
   * 
   * @param array
   * @return
   */
  public boolean isCyclic(int[] array) {
    if (array.length == 1)
      return false;
    // Keep two pointers, slow and fast and initialize them to 0th index
    int slow = 0, fast = 0;
    while (slow < array.length && fast < array.length) {
      // If the element at slow index fits between the range, set slow to that index
      if (array[slow] >= 0 && array[slow] < array.length) {
        slow = array[slow];
      } else {
        // Else increment both slow and fast and move to next iteration
        slow++;
        fast++;
        continue;
      }

      int i = 0;
      while (i < 2 && array[fast] >= 0 && array[fast] < array.length) {
        // Increment fast twice
        fast = array[fast];
        i++;
      }

      if (i < 2) {
        // This if block gets hit when array[fast] does not fit in the range. Increment fast and
        // assign slow to the incremented value
        fast++;
        slow = fast;
      } else if (slow == fast) {
        // Slow and fast have met. Return true
        return true;
      }
    }
    // Return false if this while loop exits
    return false;
  }

  // Wrapper to hold the visited array and length of the cycle
  public static class Wrapper {
    int length;
    boolean[] visited;

    public Wrapper(int length, int size) {
      this.length = length;
      this.visited = new boolean[size];
    }
  }

  public int getLongestCycleLength(int[] array) {
    int maxLength = Integer.MIN_VALUE;
    Wrapper w = new Wrapper(0, array.length);

    for (int i = 0; i < array.length; i++) {
      // Do a DFS and calculate the maximum length
      if (w.visited[i] == false) {
        w.length = 0;
        dfs(w, array, i, array[i]);
        maxLength = Math.max(w.length, maxLength);
      }
    }
    return maxLength;
  }

  private void dfs(Wrapper w, int[] array, int start, int index) {
    // Recursion exit condition, set the length to 1
    if (index >= array.length) {
      w.length = 1;
      return;
    }
    // Set visited[index] to true and increment length
    w.visited[index] = true;
    w.length++;
    if (w.visited[array[index]] == false) {
      // Check if element at index array[index] is false. If it is, recursively do dfs on
      // array[index]
      dfs(w, array, start, array[index]);
    }
  }
}
