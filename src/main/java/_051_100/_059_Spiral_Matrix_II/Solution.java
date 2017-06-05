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
    int count = 1, startRow = 0, endRow = n - 1, startCol = 0, endCol = n - 1;
    while (startCol <= endCol && startRow <= endRow) {
      for (int col = startCol; col <= endCol; col++) {
        result[startRow][col] = count++;
      }
      startRow++;
      for (int row = startRow; row <= endRow; row++) {
        result[row][endCol] = count++;
      }
      endCol--;
      if (startRow <= endRow) {
        for (int col = endCol; col >= startCol; col--) {
          result[endRow][col] = count++;
        }
      }
      endRow--;
      if (startCol <= endCol) {
        for (int row = endRow; row >= startRow; row--) {
          result[row][startCol] = count++;
        }
      }
      startCol++;
    }
    return result;
  }
}
