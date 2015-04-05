package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find intersection and union of variable size of lists
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class ListsOperations {
  public static List<Integer> intersection(List<List<Integer>> lists) {
    if (lists.size() == 1) {
      return lists.get(0);
    }
    Set<Integer> intersectionSet = new HashSet<Integer>(lists.get(0));
    int i = 1;
    while (i < lists.size()) {
      Set<Integer> secondSet = new HashSet<Integer>(lists.get(i));
      // Set's retainAll() method gives the intersection
      intersectionSet.retainAll(secondSet);
      i++;
    }
    return new ArrayList<Integer>(intersectionSet);
  }

  public static List<Integer> union(List<List<Integer>> lists) {
    if (lists.size() == 1) {
      return lists.get(0);
    }
    Set<Integer> unionSet = new HashSet<Integer>(lists.get(0));
    int i = 1;
    while (i < lists.size()) {
      Set<Integer> secondSet = new HashSet<Integer>(lists.get(i));
      // Set's addAll() method gives the union
      unionSet.addAll(secondSet);
      i++;
    }
    return new ArrayList<Integer>(unionSet);
  }
}
