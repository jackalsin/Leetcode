package _0501_0550._509_Fibonacci_Number;

/**
 * @author jacka
 * @version 1.0 on 12/9/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int fib(int N) {
    if (N <= 0) {
      return 0;
    }
    if (N <= 2) {
      return 1;
    }
    final int[] dp = new int[N + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= N; ++i) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[N];
  }
}
