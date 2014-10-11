package main;

import java.util.Stack;

/**
 * <pre>
 * Given an array, print the Next Greater Element (NGE) for every element. The next greater Element
 * for an element x is the first greater element on the right side of x in array. Elements for which
 * no greater element exist, consider next greater element as -1.
 * 
 * Examples: 
 * a) For any array, rightmost element always has next greater element as -1. 
 * b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * c) For the input array [4, 5, 2, 25}, output should be {5, 25, 25, -1}.
 * d) For the input array [13, 7, 6, 12}, output should be {-1, 12, 12, -1}
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class NextGreaterElement {
  private final int[] array;

  public NextGreaterElement(int[] array) {
    this.array = array;
  }

  public int[] getNextGreater() {
    Stack<IndexAndElement> stack = new Stack<IndexAndElement>();

    // Put first element of the array in the stack
    IndexAndElement ie = new IndexAndElement();
    ie.element = array[0];
    ie.index = 0;
    stack.push(ie);
    int[] result = new int[array.length];

    for (int i = 1; i < array.length; i++) {
      if (!stack.isEmpty()) {
        IndexAndElement indexAndElement = stack.pop();
        while (indexAndElement.element < array[i]) {
          // While popped element is less that current element in the array, update the result array
          result[indexAndElement.index] = array[i];
          if (stack.isEmpty()) {
            break;
          }
          indexAndElement = stack.pop();
        }
        // If popped element is greater than current element of array, push it back in the stack
        if (indexAndElement.element > array[i]) {
          stack.push(indexAndElement);
        }
      }
      // Push the current element in the stack
      IndexAndElement newIndexAndElement = new IndexAndElement();
      newIndexAndElement.element = array[i];
      newIndexAndElement.index = i;
      stack.push(newIndexAndElement);
    }

    // For every remaining element in the stack, put -1 at proper index in the result array
    while (!stack.isEmpty()) {
      IndexAndElement i = stack.pop();
      result[i.index] = -1;
    }

    return result;
  }

  // Class for storing index and the value at that index in result array
  public static class IndexAndElement {
    public int element;
    public int index;
  }
}
