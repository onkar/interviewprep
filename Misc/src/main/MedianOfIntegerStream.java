package main;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfIntegerStream {
  // Use priority queue to simulate minHeap and maxHeap
  private Queue<Integer> minHeap;
  private Queue<Integer> maxHeap;

  // Denotes the total number of elements in minHeap and maxHeap together
  private int size;

  public MedianOfIntegerStream() {
    this.minHeap = new PriorityQueue<Integer>();

    // 10 is passed just as a dummy size. Default implementation of PriorityQueue gives us minHeap.
    // For maxHeap we have to specify the size and a comparator function.
    this.maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
      @Override
      public int compare(Integer arg0, Integer arg1) {
        return arg1 - arg0;
      }
    });
    this.size = 0;
  }

  public void addElements(int num) {
    // Add the element directly to maxHeap first. Note that the size is not incremented yet. So
    // until size is incremented, we would be referring to the old size.
    maxHeap.add(num);

    if (size % 2 == 0) {
      // If there were even number of elements, check if the minHeap is empty
      if (minHeap.isEmpty()) {
        // Increment the size and return. Note that the element is added in maxHeap already.s
        size++;
        return;
      } else if (maxHeap.peek() > minHeap.peek()) {
        // If we run into a case where top of the maxHeap is greater than top of the minHeap, then
        // we violate a constraint that all elements in maxHeap are smaller than or equal to all
        // elements in the minHeap. So, we swap tops of both heaps.
        int maxHeapTop = maxHeap.poll();
        int minHeapTop = minHeap.poll();
        minHeap.add(maxHeapTop);
        maxHeap.add(minHeapTop);
      }
    } else {
      // This handles the case when there were odd number of elements and we added an element in the
      // max heap. This violates the constraint that number of elements in the maxHeap are either
      // equal to the number of elements in the minHeap or maxHeap has one extra element than
      // minHeap. So, we remove the top of the maxHeap and insert it to minHeap.
      minHeap.add(maxHeap.poll());
    }

    // Increment the size once element is added in either minHeap or maxHeap
    size++;
  }

  public double getMedian() {
    if (size % 2 == 0)
      // If there are even elements, then median is the average of the tops of minHeap and maxHeap
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    else
      // If there are odd elements, then median is the top of the maxHeap
      return new Double(maxHeap.peek());
  }
}
