package uber._091_Decode_Ways;

public class Solution {

  public int numDecodings(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    final int[] dp = new int[s.length() + 1];
    dp[s.length()] = 1;
    dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
    for (int i = s.length() - 2; i >= 0; i--) {
      final char singleChar = s.charAt(i);
      if (singleChar != '0') {
        dp[i] += dp[i + 1];
      }
      final int candidate = Integer.parseInt(s.substring(i, i + 2));
      if (candidate <= 26 && candidate >= 10) {
        dp[i] += dp[i + 2];
      }
    }
    return dp[0];
  }

}
