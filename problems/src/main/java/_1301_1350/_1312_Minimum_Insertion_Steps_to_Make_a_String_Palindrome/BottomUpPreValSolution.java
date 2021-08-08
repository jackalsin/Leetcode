package _1301_1350._1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public final class BottomUpPreValSolution implements Solution {

  public int minInsertions(String s) {
    if (s == null || s.isEmpty()) return 0;
    final int n = s.length();
    int[] dp = new int[n];
    final char[] chars = s.toCharArray();
    for (int i = n - 2; i >= 0; --i) {
      int prev = 0;
      for (int j = i + 1; j < n; ++j) {
        final int tmp = dp[j];
        dp[j] = chars[i] == chars[j] ? prev :
            1 + Math.min(dp[j], dp[j - 1]);
        prev = tmp;
      }
    }
    return dp[n - 1];
  }

  // dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1]:
  // 1 + Math.min(dp[i + 1][j], dp[i][j - 1])
}
