package dynamicProgramming.tutorials.fibonacci;

public final class TopDownSolution implements Solution {
  @Override
  public int fib(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException();
    }
    final int[] dp = new int[n + 1];
    fib(dp, n);
    return dp[n];
  }

  private int fib(final int[] dp, final int n) {
    if (dp[n] == 0) { // not initialize
      if (n <= 2) {
        dp[n] = 1;
        return 1;
      }
      dp[n] = fib(n - 1) + fib(n - 2);
    }
    return dp[n];
  }
}
