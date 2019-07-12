package interviews.linkedin._256_Paint_House;

/**
 * @author jacka
 * @version 1.0 on 7/10/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    final int n = costs.length;
    final int[] minCost = new int[3];
    System.arraycopy(costs[0], 0, minCost, 0, 3);
    for (int i = 1; i < n; i++) {
      final int[] prevCost = new int[3];
      System.arraycopy(minCost, 0, prevCost, 0, 3);
      minCost[0] = Math.min(prevCost[1], prevCost[2]) + costs[i][0];
      minCost[1] = Math.min(prevCost[0], prevCost[2]) + costs[i][1];
      minCost[2] = Math.min(prevCost[0], prevCost[1]) + costs[i][2];
    }
    return Math.min(Math.min(minCost[0], minCost[1]), minCost[2]);
  }
}
