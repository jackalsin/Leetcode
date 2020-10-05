package facebook._091_Decode_Ways;

public class Solution {
  /**
   * Given a non-empty string containing only digits, determine the total number of ways to decode it.
   *
   * @param s
   * @return
   */
  public int numDecodings(String s) {
    assert s.length() > 0;

    final int[] dp = new int[s.length() + 1];
    dp[0] = 1;

    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (chr != '0') {
        dp[i + 1] = dp[i];
      }

      if (i > 0) {
        final char prevChar = s.charAt(i - 1);
        if (prevChar == '1' || (prevChar == '2' && chr <= '6')) {
          dp[i + 1] += dp[i - 1];
        }
      }
    }

    return dp[s.length()];
  }
}
