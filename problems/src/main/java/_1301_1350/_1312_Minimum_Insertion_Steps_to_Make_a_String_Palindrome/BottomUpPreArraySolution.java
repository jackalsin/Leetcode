package _1301_1350._1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

public final class BottomUpPreArraySolution implements Solution {

  public int minInsertions(String s) {
    if (s == null || s.isEmpty()) return 0;
    final int n = s.length();
    int[] prev = new int[n];
    final char[] chars = s.toCharArray();
    for (int i = n - 2; i >= 0; --i) {
      final int[] cur = new int[n];
      for (int j = i + 1; j < n; ++j) {
        cur[j] = chars[i] == chars[j] ? prev[j - 1] :
            1 + Math.min(prev[j], cur[j - 1]);
      }
      prev = cur;
    }
    return prev[n - 1];
  }

  // dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1]:
  // 1 + Math.min(dp[i + 1][j], dp[i][j - 1])
}
