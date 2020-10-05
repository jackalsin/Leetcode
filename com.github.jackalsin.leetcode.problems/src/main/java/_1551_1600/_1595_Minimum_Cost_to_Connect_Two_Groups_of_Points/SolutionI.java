package _1551_1600._1595_Minimum_Cost_to_Connect_Two_Groups_of_Points;

import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/20/2020
 */
public final class SolutionI implements Solution {
  private int size1, size2;
  private int[] minCostToGroup2;
  private Integer[][] dp;
  private List<List<Integer>> cost;

  public int connectTwoGroups(List<List<Integer>> cost) {
    /*
     * 这题不是greedy. DFS 实际return了所有possibilities，他试验了每一个可能性对于任意一个 i in left group,
     * 剩下的在size2中，没有visited的就选择greedy最小
     */
    size1 = cost.size();
    size2 = cost.get(0).size();
    this.cost = cost;
    minCostToGroup2 = new int[size2];
    Arrays.fill(minCostToGroup2, Integer.MAX_VALUE);
    for (int i = 0; i < size1; ++i) {
      for (int j = 0; j < size2; ++j) {
        minCostToGroup2[j] = Math.min(minCostToGroup2[j], cost.get(i).get(j));
      }
    }
    dp = new Integer[size1 + 1][(1 << size2)];
    return dfs(0, 0);
  }

  private int dfs(final int i, final int visited) {
    if (dp[i][visited] != null) return dp[i][visited];
    if (i >= size1) { // all point1 in group1 has 1 corresponding point in group2
      int result = 0;
      for (int j = 0; j < size2; ++j) {
        if (((1 << j) & visited) == 0) {
          result += minCostToGroup2[j];
        }
      }
      dp[i][visited] = result;
      return result;
    } else {
      int result = Integer.MAX_VALUE;
      for (int j = 0; j < size2; ++j) {
        final int remain = dfs(i + 1, visited | (1 << j));
        assert remain != Integer.MAX_VALUE;
        result = Math.min(result, cost.get(i).get(j) + remain);
      }
      dp[i][visited] = result;
      return result;
    }
  }
}
