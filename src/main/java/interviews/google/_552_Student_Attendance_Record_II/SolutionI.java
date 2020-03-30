package interviews.google._552_Student_Attendance_Record_II;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/29/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private int[][][] dp;

  public int checkRecord(int n) {
    dp = new int[n][2][3];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < 2; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    return dfs(n, 0, 0, 0);
  }

  private int dfs(final int N, final int i, final int aCount, final int lastLCount) {
    if (i == N) {
      return 1;
    }
    if (dp[i][aCount][lastLCount] != -1) {
      return dp[i][aCount][lastLCount];
    }
    int res = dfs(N, i + 1, aCount, 0); // use P
    if (aCount < 1) {
      res = safeAdd(res, dfs(N, i + 1, aCount + 1, 0));
    }
    if (lastLCount < 2) {
      res = safeAdd(res, dfs(N, i + 1, aCount, lastLCount + 1));
    }
    dp[i][aCount][lastLCount] = res;
    return res;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }
}
