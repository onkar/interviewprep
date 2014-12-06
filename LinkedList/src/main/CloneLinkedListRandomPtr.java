package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Clone a linked list that has a random pointer along with the usual next pointer
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class CloneLinkedListRandomPtr {
  public LinkedListRandomPtr clone(LinkedListRandomPtr head) {
    if (head == null)
      return null;
    // Keep a map to keep track of corresponding new node in the cloned list
    Map<LinkedListRandomPtr, LinkedListRandomPtr> map =
        new HashMap<LinkedListRandomPtr, LinkedListRandomPtr>();
    LinkedListRandomPtr newHead = new LinkedListRandomPtr(head.data);
    map.put(head, newHead);

    LinkedListRandomPtr p = head;
    LinkedListRandomPtr q = newHead;

    p = p.next;

    // Copy elements in the cloned list by following next pointer. Also, update the map once the
    // clone node is created.
    while (p != null) {
      LinkedListRandomPtr temp = new LinkedListRandomPtr(p.data);
      map.put(p, temp);
      q.next = temp;
      p = p.next;
      q = temp;
    }

    // Rewind p and q to the beginning of the lists
    p = head;
    q = newHead;

    while (p != null) {
      // If p has a random pointer, find the corresponding node for p's random pointer from map and
      // assign that node to q's random pointer. Else assign null
      if (p.random != null) {
        q.random = map.get(p.random);
      } else {
        q.random = null;
      }
      p = p.next;
      q = q.next;
    }
    return newHead;
  }
}
