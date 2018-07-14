package interviews.microsoft._091_Decode_Ways;

public class Solution {
  public int numDecodings(String s) {
    assert s.length() > 0;
    final int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    for (int i = 0; i < s.length(); i++) {
      int count = s.charAt(i) - '0';
      if (count > 0) {
        dp[i + 1] += dp[i];
      }

      if (i > 0) {
        count += (s.charAt(i - 1) - '0') * 10;
        if (10 <= count && count <= 26) {
          dp[i + 1] += dp[i - 1];
        }
      }
    }
    return dp[s.length()];
  }
}
