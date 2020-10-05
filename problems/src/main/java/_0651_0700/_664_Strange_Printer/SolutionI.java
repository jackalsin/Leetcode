package _0651_0700._664_Strange_Printer;

/**
 * @author jacka
 * @version 1.0 on 3/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int strangePrinter(String s) {
    /*
     * 假设有个string，我们应该先print出两个端点
     * "acccccca" -> 如果不print端点先，那么需要3次，否则2次
     */
    if (s == null || s.length() == 0) {
      return 0;
    }
    final char[] chars = s.toCharArray();
    final int n = s.length();
    final int[][] dp = new int[n][n];
    for (int i = 0; i < n; ++i) {
      dp[i][i] = 1;
    }
    for (int i = n - 1; i >= 0; --i) {
      for (int j = i + 1; j < n; ++j) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k + 1 <= j; k++) {
          // if [i...k][k + 1...j], 如果chars[k] == chars[j], 那么print chars[j]的时候可以一起print出来，少了1次turn
          // One thing we need to know is that the best printing stratege is to print the two endpoints ( the innner
          //  part is painted together) firstly.
          // So we can reduce the sum of two sub questions when:
          //
          // s.charAt(start) == s.charAt(start + k + 1)
          // s.charAt(start + k) == s.charAt(start + k + 1)
          // s.charAt(start + k) == s.charAt(start + len)
          // s.charAt(start) == s.charAt(start + len)
          // However, 1-3 situations will be included in the sub questions (left sub or right sub) when moving the
          //  breakpoint.
          //
          // All we need to consider is situation 4, and this can be judged out of the third inner loop.
          final int cur = dp[i][k] + dp[k + 1][j] - (chars[k] == chars[j] ? 1 : 0);
          dp[i][j] = Math.min(dp[i][j], cur);
        }
      }
    }
    return dp[0][n - 1];
  }
}
