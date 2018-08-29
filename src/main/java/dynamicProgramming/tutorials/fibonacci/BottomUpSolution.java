package dynamicProgramming.tutorials.fibonacci;

public final class BottomUpSolution implements Solution {
  @Override
  public int fib(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    } else if (n <= 2) {
      return 1;
    }
    final int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
