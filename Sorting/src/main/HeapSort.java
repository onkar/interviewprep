package main;

/**
 * Time complexity: O(nlogn) because maxHeapify() takes O(logn) and createHeap() takes O(n). Space
 * complexity is O(n).
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class HeapSort {
  private final int[] array;
  private int size;

  public HeapSort(int[] array, int size) {
    this.array = array;
    this.size = size;
  }

  /**
   * <pre>
   * Input data: [4, 10, 3, 5, 1]
   *     
   *              4(0)
   *             /   \
   *          10(1)  3(2)
   *          /   \
   *        5(3)  1(4)
   * </pre>
   */
  public void sort() {
    createHeap();
    // Do this again all elements are placed in proper positions
    while (size > 1) {
      /**
       * Replace root element (which is the maximum element of current heap) with last element. This
       * is done to fix the position of the maximum element. Then the size of array is reduced so
       * that the last element which we just fixed doesn't get affected later during the algorithm.
       */
      swap(0, size - 1);
      size--;
      // Once one element is fixed, trigger the algorithm again by calling maxHeapify() on the root
      // element.
      maxHeapify(0);
    }
  }

  /**
   * Start from the rightmost internal node and go up to the root node. Internal node is a node
   * which has at least one child. For each internal node, call maxHeapify().
   */
  private void createHeap() {
    for (int i = (size - 2) / 2; i >= 0; i--) {
      maxHeapify(i);
    }
  }

  /**
   * Given an index, create a maximum heap. This means, bring the largest node at the root of this
   * heap. To do this, compare left and right children with the root and swap the elements such that
   * maximum number is at the largest index. Then recursively heapify the subtree also. For given
   * tree, index = 1 (index of 10). Since the children (5 and 1) are smaller, there is no swap. For
   * the next iteration, maxHeapfiy will be called on index = 0. 4 will be swapped with 10, then
   * maxHeapify will be called again for 4 (index = 1) and 5(index = 3) will be swapped with it. The
   * result will be -
   * 
   * <pre>
   *                 10(0)
   *                /    \
   *              5(1)   3(2)
   *             /  \
   *           4(3)  1(4)
   * </pre>
   * 
   * @param index The array index to be heapified
   */
  private void maxHeapify(int index) {
    int largestIndex = index;
    int leftIndex = 2 * index + 1;
    int rightIndex = 2 * index + 2;

    if (leftIndex < size && array[leftIndex] > array[largestIndex]) {
      largestIndex = leftIndex;
    }

    if (rightIndex < size && array[rightIndex] > array[largestIndex]) {
      largestIndex = rightIndex;
    }

    if (largestIndex != index) {
      swap(largestIndex, index);
      maxHeapify(largestIndex);
    }
  }

  private void swap(int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
