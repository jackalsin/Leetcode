package _051_100._059_Spiral_Matrix_II;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/21/2017.
 */
public class Solution {
  private static final int[][] DIR = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      return new int[][]{};
    }
    int[][] result = new int[n][n];
    int count = 1, dirIndex = 0, row = 0, col = 0;
    while (count != n *n + 1) {
      result[row][col] = count++;
      if (result[row + DIR[dirIndex%4][0]][col + DIR[dirIndex%4][1]] != 0) {
        dirIndex++;
      }
    }
    return result;
  }
}
