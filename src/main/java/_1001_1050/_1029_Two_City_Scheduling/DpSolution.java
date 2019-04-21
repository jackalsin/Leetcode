package _1001_1050._1029_Two_City_Scheduling;

public final class DpSolution implements Solution {
  public int twoCitySchedCost(int[][] costs) {
    final int N = costs.length / 2;
    // dp[i][j] i -> A, j -> B
    final int[][] dp = new int[N + 1][N + 1];
    for (int i = 0; i < N; i++) {
      dp[0][i + 1] = dp[0][i] + costs[i][1];
    }

    for (int i = 0; i < N; i++) {
      dp[i + 1][0] = dp[i][0] + costs[i][0];
      for (int j = 0; j < N; j++) {
        dp[i + 1][j + 1] = Math.min(dp[i + 1][j] + costs[i + 1 + j][1], dp[i][j + 1] + costs[i + 1 + j][0]);
      }
    }
    return dp[N][N];
  }
}
