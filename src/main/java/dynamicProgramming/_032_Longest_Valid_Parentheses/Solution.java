package dynamicProgramming._032_Longest_Valid_Parentheses;

public class Solution {

  /**
   *
   * @param s
   * @return
   */
  public int longestValidParentheses(String s) {
    final int[] dp = new int[s.length() + 1];
    int res = 0, leftCount = 0;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (chr == '(') {
        leftCount++;
      } else {
        if (leftCount > 0) {
          dp[i + 1] = dp[i] + 2; // (())
          dp[i + 1] += dp[i + 1 - dp[i + 1]]; //()()
          res = Math.max(res, dp[i + 1]);
          leftCount--;
        }
      }
    }
//    System.out.println(Arrays.toString(dp));
    return res;
  }
}
