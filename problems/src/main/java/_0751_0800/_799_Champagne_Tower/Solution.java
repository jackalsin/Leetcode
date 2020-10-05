package _0751_0800._799_Champagne_Tower;

public class Solution {
  public double champagneTower(int poured, int query_row, int query_glass) {
    final double[][] liquid = new double[101][101];
    liquid[0][0] = poured;
    for (int row = 0; row <= query_row; row++) {
      for (int col = 0; col <= row; col++) {
        if (liquid[row][col] > 1) {
          liquid[row + 1][col] += (liquid[row][col] - 1) / 2d;
          liquid[row + 1][col + 1] += (liquid[row][col] - 1) / 2d;
          liquid[row][col] = 1;
        }
      }
    }

    return liquid[query_row][query_glass];
  }


}
