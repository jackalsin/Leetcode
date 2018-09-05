package interviews.linkedin.mianjing._746_Min_Cost_Climbing_Stairs;

public class Solution {

  public int minCostClimbingStairs(int[] cost) {
    if (cost == null || cost.length == 0) {
      return 0;
    }
    final int[] minCosts = new int[cost.length + 2];
    for (int i = 0; i <= cost.length; ++i) {
      final int curCost = i == cost.length ? 0 : cost[i];
      minCosts[i + 1] = minCosts[i + 1 - 1] + curCost;
      if (i + 1 - 2 >= 0) {
        minCosts[i + 1] = Math.min(minCosts[i + 1], minCosts[i + 1 - 2] + curCost);
      }
    }
    return minCosts[cost.length + 1];
  }


}
