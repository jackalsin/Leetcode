package _551_600._552_Student_Attendance_Record_II;

public class Solution {
  private static final long MOD = 7 + (long) 1E9;

  public int checkRecord(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 3;
    } else if (n == 2) {
      return 8;
    }
    final long[][] dp = new long[5][n];
    dp[0][0] = 1; // p without A
    dp[1][0] = 0; // p with A
    dp[2][0] = 1; // l without A
    dp[3][0] = 0; // l with A
    dp[4][0] = 1; // A

    dp[0][1] = 2; // p without A
    dp[1][1] = 1; // p with A
    dp[2][1] = 2; // l without A
    dp[3][1] = 1; // l with A
    dp[4][1] = 2; // A
    for (int i = 2; i < n; i++) {
      dp[0][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
      dp[1][i] = ((dp[4][i - 1] + dp[3][i - 1]) % MOD + dp[1][i - 1]) % MOD;
      dp[2][i] = ((dp[0][i - 2] + dp[0][i - 2]) % MOD + dp[2][i - 2]) % MOD;
      dp[3][i] = ((dp[4][i - 2] + dp[1][i - 2]) % MOD + (dp[4][i - 1] + dp[4][i - 2]) % MOD + (dp[3][i - 2] + dp[1][i - 2]) % MOD) % MOD;
      dp[4][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
    }
    long sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += dp[i][n - 1];
      sum %= MOD;
    }
    return (int) sum;
  }

}
