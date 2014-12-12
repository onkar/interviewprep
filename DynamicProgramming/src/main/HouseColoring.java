package main;

/**
 * There are a row of houses. Each house can be painted with three colors: red, blue and green. The
 * cost of painting each house with a certain color is different. You have to paint all the houses
 * such that no two adjacent houses have the same color. You have to paint the houses with minimum
 * cost. How would you do it?
 * 
 * Note: The cost of painting house 1 red is different from that of painting house 2 red. Each
 * combination of house and color has its own cost.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class HouseColoring {
  int[][] costMatrix;

  public HouseColoring(int[][] costMatrix) {
    this.costMatrix = costMatrix;
  }

  // We can paint ith house with Blue, Red or Green. So, the dynamic programming equation becomes
  // cost[i, Red] = min (cost[i-1, Blue], cost[i-1, Green]) + cost of painting i with Red
  // cost[i, Blue] = min (cost[i-1, Red], cost[i-1, Green]) + cost of painting i with Blue
  // cost[i, Green] = min (cost[i-1, Red], cost[i-1, Blue]) + cost of painting i with Green
  // And minimum cost = min(cost[n, Red], min(cost[n, Blue], cost[n, Green]))
  public int houseColoringCost() {
    int rows = costMatrix.length;
    int cols = costMatrix[0].length;
    int[][] cost = new int[rows][cols];

    // Copy 0th row as is in the result matrix
    for (int j = 0; j < cols; j++) {
      cost[0][j] = costMatrix[0][j];
    }
    for (int i = 1; i < rows; i++) {
      // 0th column is Red, 1st is Green and 2nd is Blue. NOTE: costMatrix is an input matrix while
      // cost matrix is the result matrix
      cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + costMatrix[i][0];
      cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + costMatrix[i][1];
      cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + costMatrix[i][2];
    }

    return Math.min(cost[rows - 1][0], Math.min(cost[rows - 1][1], cost[rows - 1][2]));
  }
}
