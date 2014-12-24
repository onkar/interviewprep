package main;

/**
 * <pre>
 * Given k sorted arrays of size n each, merge them in one sorted output array. For example,
 * 
 * arr[][] = { {1, 3, 5, 7},
 *             {2, 4, 6, 8},
 *             {0, 9, 10, 11} };
 *             
 * The output should be {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class MergeKSortedArrays {
  /**
   * MinHeapNode stores actual array element, array number and index of the next element in a
   * particular array.
   */
  class MinHeapNode {
    public int i; // The array number
    public int j; // Index of the next element in the array
    public int element; // The array element
  }
  /**
   * MinHeap operations
   */
  public static class MinHeap {
    private final MinHeapNode[] array;
    private final int size;

    public MinHeap(MinHeapNode[] array, int size) {
      this.array = array;
      this.size = size;
      for (int i = (this.size - 2) / 2; i >= 0; i--) {
        minHeapify(i);
      }
    }

    public void minHeapify(int index) {
      // Consider the passed in index as the smallest index and get left and right indexes
      int smallestIndex = index;
      int leftIndex = 2 * index + 1;
      int rightIndex = 2 * index + 2;

      // Check if element in the left index is smaller than the element at passed in index. If yes,
      // update the smallest index with left index.
      if (leftIndex < size && array[leftIndex].element < array[index].element) {
        smallestIndex = leftIndex;
      }
      // Check if the element in the right index is smaller than the element at the smallest index.
      // If yes, update the smallest index with right index.
      if (rightIndex < size && array[rightIndex].element < array[smallestIndex].element) {
        smallestIndex = rightIndex;
      }
      // If smallest index is not same as passed in index, swap the elements at smallest and passed
      // in index and call minHeapify on the smallest index.
      if (smallestIndex != index) {
        swap(smallestIndex, index);
        minHeapify(smallestIndex);
      }
    }

    private void swap(int i, int j) {
      MinHeapNode temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }

    public MinHeapNode getMin() {
      return array[0];
    }

    void replaceMin(MinHeapNode newMin) {
      array[0] = newMin;
      minHeapify(0);
    }
  }

  /**
   * The actual algorithm
   */
  public int[] merge(int[][] input) {
    // k = number of rows, n = no. of elements in each row
    int k = input.length;
    int n = input[0].length;

    // Initialize output array with k * n elements and heapArray to store the minimum heap of size k
    int[] output = new int[k * n];
    MinHeapNode[] heapArray = new MinHeapNode[k];
    for (int i = 0; i < k; i++) {
      heapArray[i] = new MinHeapNode();
    }

    // Copy first element (which is the smallest of that array) from each array into the heapArray.
    for (int i = 0; i < k; i++) {
      heapArray[i].element = input[i][0];
      heapArray[i].i = i; // i is the array number
      heapArray[i].j = 1; // j is the index of the next element in that array. Initialize it with 1.
    }

    // Create the minHeap using the array
    MinHeap minHeap = new MinHeap(heapArray, heapArray.length);
    for (int i = 0; i < n * k; i++) {
      // Get the minimum element in the heap and copy it to the output array at index i
      MinHeapNode root = minHeap.getMin();
      output[i] = root.element;

      // Save the next element in root
      if (root.j < n) {
        root.element = input[root.i][root.j];
        root.j += 1;
      } else {
        root.element = Integer.MAX_VALUE;
      }

      // Replace root as the minimum element in the heap so that minHeapify will get triggered and
      // actual min will come up as the root for next iteration.
      minHeap.replaceMin(root);
    }
    return output;
  }
}
