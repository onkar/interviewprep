package main;

import java.util.Stack;

/**
 * Implement the stack which will do the min(), push() and pop() in O(1) time complexity.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class StackWithMin {
  private final Stack<Integer> stack;
  int min;

  public StackWithMin() {
    this.stack = new Stack<Integer>();
    this.min = 0;
  }

  public void push(int item) {
    if (stack.isEmpty()) {
      // Initially, push the first element to the stack and set it as the minimum element
      stack.push(item);
      min = item;
      return;
    }
    if (item >= min) {
      // If the element is greater than minimum, directly push it
      stack.push(item);
    } else {
      // If the element is smaller than min, we need to update min. Push 2 * element - min to the
      // stack and update min to the element
      stack.push(2 * item - min);
      min = item;
    }
  }

  public int pop() {
    if (stack.isEmpty()) {
      // Throw exception when the stack is empty
      throw new IllegalStateException("Popping from an empty stack");
    }
    if (stack.peek() < min) {
      // Save the current value of min in topToBeReturned.
      int topToBeReturned = min;
      // Update the min to the last value of min
      min = 2 * min - stack.peek();
      // Pop the element because we don't need it anymore (we have already updated min).
      stack.pop();
      // Return lastMin as the popped value
      return topToBeReturned;
    }
    // Return popped element
    return stack.pop();
  }

  // Another way to solve this is to use an extra stack for minimum values. In push(), check if the
  // pushed element is the new minimum. If it is, the push it to the minimum stack as well. In
  // pop(), check if the popped element is same as the current minimum. If it is, pop it from the
  // minimum stack as well.

  public int min() {
    return min;
  }
}
