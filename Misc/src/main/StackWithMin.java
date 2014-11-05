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
      // If the top of the stack is less than the min, update min
      min = 2 * min - stack.peek();
    }
    // Return popped element
    return stack.pop();
  }

  public int min() {
    return min;
  }
}
