package linkedin._256_Paint_House;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  private static final int N = 3;

  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    int[] preCost = new int[N];
    System.arraycopy(costs[0], 0, preCost, 0, N);
    for (int row = 1; row < costs.length; ++row) {
      final int[] curCost = new int[N];
      Arrays.fill(curCost, Integer.MAX_VALUE);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (i != j) {
            curCost[i] = Math.min(costs[row][i] + preCost[j], curCost[i]);
          }
        }
      }
      System.arraycopy(curCost, 0, preCost, 0, N);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      min = Math.min(min, preCost[i]);
    }
    return min;
  }
}
