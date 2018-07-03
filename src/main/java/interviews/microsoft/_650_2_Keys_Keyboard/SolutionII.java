package interviews.microsoft._650_2_Keys_Keyboard;

public final class SolutionII implements Solution {
  public int minSteps(int n) {
    assert n >= 1;
    if (n == 1) {
      return 0;
    } else if (n <= 4) {
      return n;
    }

    final int[] dp = new int[n + 1];
    dp[1] = 0;
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = 4;


    for (int i = 5; i <= n; i++) {
      dp[i] = i;
      for (int factor = 2; factor < i; factor++) {
        if (i % factor == 0) {
          dp[i] = Math.min(dp[i], dp[factor] + (i / factor));
        }
      }
    }
    return dp[n];
  }
}
