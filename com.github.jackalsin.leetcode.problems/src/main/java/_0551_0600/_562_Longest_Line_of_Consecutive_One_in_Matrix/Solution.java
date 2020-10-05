package _0551_0600._562_Longest_Line_of_Consecutive_One_in_Matrix;

public class Solution {
  public int longestLine(int[][] M) {
    if (M == null || M.length == 0 || M[0].length == 0) {
      return 0;
    }
    final int rows = M.length, cols = M[0].length;
    final int[][] triangle = new int[rows][cols]; // later will be reused as
    int maxSofar = 0, curSofar = 0;
    for (int row = 0; row < rows; row++) {
      curSofar = 0;
      for (int col = 0; col < cols; col++) {
        if (M[row][col] == 1) {
          curSofar++;
          maxSofar = Math.max(maxSofar, curSofar);
          // triangle
          if (row == 0 || col == 0) {
            triangle[row][col] = 1;
          } else {
            triangle[row][col] = triangle[row - 1][col - 1] + 1;
          }
          maxSofar = Math.max(maxSofar, triangle[row][col]);
        } else {
          curSofar = 0;
          // triangle
          triangle[row][col] = 0;
        }
      }
    }
    System.out.println("Rows Max = " + maxSofar);

    for (int col = 0; col < cols; col++) {
      curSofar = 0;
      for (int row = 0; row < rows; row++) {
        if (M[row][col] == 1) {
          curSofar++;
          maxSofar = Math.max(maxSofar, curSofar);
        } else {
          curSofar = 0;
        }
      }
    }

    System.out.println("after col Max = " + maxSofar);

    // anti triangle
    for (int row = 0; row < rows; row++) {
      for (int col = cols - 1; col >= 0; col--) {
        if (M[row][col] == 1) {
          if (row == 0 || col == cols - 1) {
            triangle[row][col] = 1;
          } else {
            triangle[row][col] = triangle[row - 1][col + 1] + 1;
          }
          maxSofar = Math.max(maxSofar, triangle[row][col]);
        } else {
          triangle[row][col] = 0;
        }
      }
    }

    for (int col = 0; col < cols; col++) {
      maxSofar = Math.max(maxSofar, triangle[rows - 1][col]);
    }

    for (int row = 0; row < rows; row++) {
      maxSofar = Math.max(maxSofar, triangle[row][0]);
    }

    return maxSofar;
  }
}
