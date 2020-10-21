package _1001_1050._1030_Matrix_Cells_in_Distance_Order;

/**
 * @author jacka
 * @version 1.0 on 10/20/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    final int[] distanceCount = new int[R + C + 1];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; ++j) {
        final int distance = Math.abs(r0 - i) + Math.abs(c0 - j);
        distanceCount[distance + 1]++;
      }
    }

    for (int i = 1; i < distanceCount.length; i++) {
      distanceCount[i] += distanceCount[i - 1];
    }
    final int[][] result = new int[R * C][];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; ++j) {
        final int distance = Math.abs(r0 - i) + Math.abs(c0 - j);
        result[distanceCount[distance]++] = new int[]{i, j};
      }
    }
    return result;
  }
}
