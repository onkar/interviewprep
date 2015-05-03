package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

  // Helper class to hold the list number, element in the list and index of the next element in the
  // same list
  class ListAndIndex {
    int listNo;
    int element;
    int nextElementIndex;

    public ListAndIndex(int listNo, int element, int nextElementIndex) {
      this.listNo = listNo;
      this.element = element;
      this.nextElementIndex = nextElementIndex;
    }
  }

  public List<Integer> merge(List<ArrayList<Integer>> lists) {
    if (lists.size() == 0)
      return null;

    // Use priority queue as the min heap. The size of this min heap is always going to be the
    // number of lists (k in this case).
    PriorityQueue<ListAndIndex> q =
        new PriorityQueue<ListAndIndex>(lists.size(), new Comparator<ListAndIndex>() {
          @Override
          public int compare(ListAndIndex a, ListAndIndex b) {
            if (a.element > b.element)
              return 1;
            else if (a.element < b.element)
              return -1;
            else
              return 0;
          }
        });

    // Take 0th element from each list and put it in the min heap
    for (int i = 0; i < lists.size(); i++) {
      List<Integer> l = lists.get(i);
      ListAndIndex lai = new ListAndIndex(i, l.get(0), 1);
      q.add(lai);
    }

    List<Integer> result = new ArrayList<Integer>();

    while (!q.isEmpty()) {
      // Get the smallest from the minheap and put in the result list
      ListAndIndex smallest = q.poll();
      result.add(smallest.element);

      // Save next index and next list number from the current smallest element
      int nextIndex = smallest.nextElementIndex;
      int nextListNo = smallest.listNo;

      // If the next index is outside the bounds, then don't add it in the queue. This condition
      // makes sure that heap is not populated infinitely.
      if (nextIndex < lists.get(nextListNo).size()) {
        // When adding the next number to heap, make sure to increment next index by 1 since this
        // is the new element
        ListAndIndex next =
            new ListAndIndex(nextListNo, lists.get(nextListNo).get(nextIndex), nextIndex + 1);
        q.add(next);
      }
    }

    return result;
  }
}
