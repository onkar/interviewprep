package runnable;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Calculate addition of matrix elements using multiple threads and CyclicBarrier
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MatrixElementAddition {
  int columns;
  int rows;
  int[][] matrix;
  CyclicBarrier barrier;
  int matrixSum;

  public MatrixElementAddition(int columns, int rows, int[][] matrix) {
    this.columns = columns;
    this.rows = rows;
    this.matrix = matrix;
    this.matrixSum = 0;
    this.barrier = new CyclicBarrier(rows, new Runnable() {
      @Override
      public void run() {
        System.out.println("Addition is : " + matrixSum);
      }
    });
  }

  public void solve() {
    for (int i = 0; i < rows; i++) {
      new Thread(new Worker(i)).start();
    }
  }

  class Worker implements Runnable {
    int rowToBeProcessed;

    public Worker(int rowToBeProcessed) {
      this.rowToBeProcessed = rowToBeProcessed;
    }

    @Override
    public void run() {
      for (int j = 0; j < columns; j++) {
        matrixSum += matrix[rowToBeProcessed][j];
      }
      try {
        barrier.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] { {1, 2, 3}, {4, 5, 6}};
    MatrixElementAddition solver = new MatrixElementAddition(3, 2, matrix);
    solver.solve();
  }
}
