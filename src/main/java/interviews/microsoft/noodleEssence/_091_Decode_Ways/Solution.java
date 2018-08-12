package interviews.microsoft.noodleEssence._091_Decode_Ways;

public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    final int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    for (int i = 0; i < s.length(); i++) {
      final int curDigit = s.charAt(i) - '0';
      if (curDigit != 0) {
        dp[i + 1] = dp[i];
      }
      if (i > 0) {
        final int preDigit = s.charAt(i - 1) - '0';
        if (preDigit == 1) {
          dp[i + 1] += dp[i - 1];
        } else if (preDigit == 2 && curDigit <= 6) {
          dp[i + 1] += dp[i - 1];
        }
      }
    }
    return dp[s.length()];
  }
}
