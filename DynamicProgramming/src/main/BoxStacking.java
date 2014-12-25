package main;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i),
 * width w(i) and depth d(i) (all real numbers). You want to create a stack of boxes which is as
 * tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D
 * base of the lower box are each strictly larger than those of the 2-D base of the higher box. Of
 * course, you can rotate a box so that any side functions as its base. It is also allowable to use
 * multiple instances of the same type of box.
 * 
 * For simplicity, consider depth as always smaller than or equal to width.
 * 
 * <pre>
 * 
 * MSH(i) = Maximum possible Stack Height with box i at top of stack
 * MSH(i) = { Max ( MSH(j) ) + height(i) } 
 * where j < i and width(j) > width(i) and depth(j) > depth(i). If there is no such j
 * then MSH(i) = height(i)
 * 
 * To get overall maximum height, we return max(MSH(i)) where 0 < i < n
 * 
 * <pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class BoxStacking {

  public static class Box {
    public int h, w, d;

    public Box() {}

    public Box(int h, int w, int d) {
      this.h = h;
      this.w = w;
      this.d = d;
    }
  }

  public int maxStackHeight(Box[] boxes) {
    int n = boxes.length;
    // We can rotate boxes. For example, if there's a box with dimensions [1, 2, 3] where 1 is the
    // height and 2 * 3 is the base, then there can be three possibilities - [1, 2, 3], [2, 1, 3],
    // [3, 1, 2]
    Box[] rotations = new Box[3 * n];
    for (int i = 0; i < rotations.length; i++) {
      rotations[i] = new Box();
    }
    int index = 0;
    for (int i = 0; i < n; i++) {
      rotations[index] = boxes[i];
      index++;

      rotations[index].h = boxes[i].w;
      rotations[index].w = Math.min(boxes[i].h, boxes[i].d);
      rotations[index].d = Math.max(boxes[i].h, boxes[i].d);
      index++;

      rotations[index].h = boxes[i].d;
      rotations[index].w = Math.min(boxes[i].h, boxes[i].w);
      rotations[index].d = Math.max(boxes[i].h, boxes[i].w);
      index++;
    }

    // Sort the rotations in decreasing order of the base area (width * depth)
    Arrays.sort(rotations, new Comparator<Box>() {
      @Override
      public int compare(Box o1, Box o2) {
        return o2.d * o2.w - o1.d * o1.w;
      }
    });

    int[] maxStackHeight = new int[3 * n];
    for (int i = 0; i < 3 * n; i++)
      maxStackHeight[i] = rotations[i].h;

    for (int i = 1; i < 3 * n; i++) {
      for (int j = 0; j < i; j++) {
        if (rotations[i].w < rotations[j].w && rotations[i].d < rotations[j].d
            && maxStackHeight[i] < maxStackHeight[j] + rotations[i].h) {
          maxStackHeight[i] = maxStackHeight[j] + rotations[i].h;
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < maxStackHeight.length; i++) {
      if (maxStackHeight[i] > max)
        max = maxStackHeight[i];
    }
    return max;
  }
}
