package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import main.OverlappingIntervals.TimeFrame;

/**
 * Merge overlapping intervals -
 * 
 * <pre>
 * e.g. {(1, 3), (2, 4), (5, 7), (6, 8)} should get converted to 
 * {(1,4), (5, 8)}
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class OverlappingIntervals {
  private final List<TimeFrame> intervals;
  private final Stack<TimeFrame> stack;

  // Inner helper class
  public class TimeFrame {
    public int startTime;
    public int endTime;
    public TimeFrame(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }

  public OverlappingIntervals() {
    intervals = new ArrayList<TimeFrame>();
    TimeFrame t1 = new TimeFrame(2, 4);
    TimeFrame t2 = new TimeFrame(1, 3);
    TimeFrame t3 = new TimeFrame(5, 7);
    TimeFrame t4 = new TimeFrame(6, 8);
    intervals.add(t1);
    intervals.add(t2);
    intervals.add(t3);
    intervals.add(t4);
    stack = new Stack<TimeFrame>();
  }

  public List<TimeFrame> mergedIntervals() {
    // Sort intervals based on start time
    Collections.sort(intervals, new IntervalStartComparator());
    // Put first element in the stack
    stack.push(intervals.remove(0));
    int index = 0;
    while (!intervals.isEmpty()) {
      TimeFrame t = intervals.remove(index);
      TimeFrame temp = stack.peek();
      TimeFrame newInterval;
      if (t.startTime <= temp.endTime) {
        // If start time of the list element is less than or equal to top of the stack's end time,
        // pop existing element and push a modified element
        stack.pop();
        newInterval = new TimeFrame(temp.startTime, t.endTime);
      } else {
        // Add list element in the stack
        newInterval = new TimeFrame(t.startTime, t.endTime);
      }
      stack.push(newInterval);
    }
    List<TimeFrame> result = new ArrayList<TimeFrame>();
    result.addAll(stack);
    return result;
  }
}


// Comparator used for comparing the time intervals
class IntervalStartComparator implements Comparator<TimeFrame> {
  @Override
  public int compare(TimeFrame x, TimeFrame y) {
    Integer x1 = x.startTime;
    Integer y1 = y.startTime;
    return x1.compareTo(y1);
  }
}


