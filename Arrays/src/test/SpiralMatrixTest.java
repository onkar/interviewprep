package test;

import main.SpiralMatrix;

import org.junit.Test;

public class SpiralMatrixTest {
  @Test
  public void test() {
    int[][] matrix1 =
        { {11, 12, 13, 14, 15}, {21, 22, 23, 24, 25}, {31, 32, 33, 34, 35}, {41, 42, 43, 44, 45}};
    SpiralMatrix.printSpiral(matrix1);
    System.out.println();
    int[][] matrix2 = {{1}};
    SpiralMatrix.printSpiral(matrix2);
    System.out.println();
    int[][] matrix3 = {{}};
    SpiralMatrix.printSpiral(matrix3);
    System.out.println();
    int[][] matrix4 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    SpiralMatrix.printSpiral(matrix4);
    System.out.println();
    int[][] matrix5 = { {1, 2}, {3, 4}, {5, 6}};
    SpiralMatrix.printSpiral(matrix5);
    System.out.println();

    int[][] matrix6 =
        { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}};
    SpiralMatrix.printSpiral(matrix6);
  }
}
