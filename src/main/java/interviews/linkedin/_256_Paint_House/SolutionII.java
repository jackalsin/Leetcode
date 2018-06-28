package interviews.linkedin._256_Paint_House;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  private static final int N = 3;

  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    final int[] minCost = new int[N];
    for (int i = 0; i < costs.length; i++) {
      final int[] prevCost = new int[N];
      System.arraycopy(minCost, 0, prevCost, 0, N);
      for (int color = 0; color < N; color++) {
        int minNoCurColor = Integer.MAX_VALUE;

        for (int j = 0; j < N; j++) {
          if (color != j) {
            minNoCurColor = Math.min(minNoCurColor, prevCost[j]);
          }
        }

        minCost[color] = minNoCurColor + costs[i][color];
      }
    }

    int min = minCost[0];
    for (int i = 1; i < minCost.length; i++) {
      min = Math.min(minCost[i], min);
    }
    return min;
  }
}
