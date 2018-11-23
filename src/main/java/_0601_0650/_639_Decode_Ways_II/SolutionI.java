package _0601_0650._639_Decode_Ways_II;

public final class SolutionI implements Solution {
  private static final int MOD = 1_000_000_000 + 7;

  public int numDecodings(String s) {
    if (s.length() == 0) {
      return 0;
    }
    final int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      // add single digit possible
      if (chr == '*') {
        dp[i + 1] = safeMultiple(dp[i], 9);
      } else if (chr != '0') {
        dp[i + 1] = dp[i];
      }

      // double digit;
      if (i == 0) {
        continue;
      }

      final char prevChar = s.charAt(i - 1);
      if (prevChar == '*') {
        if (chr == '*') {
          dp[i + 1] += safeMultiple(dp[i - 1], 15); // 11- 19 + 21 - 26
        } else {// e.g. *2
          // *0 -> 10, 20
          // *9 -> 19
          dp[i + 1] += safeMultiple(dp[i - 1], (6 >= chr - '0') ? 2 : 1);
        }
      } else if (prevChar == '1') {
        if (chr == '*') { // 1* -> 11 ~ 19
          dp[i + 1] += safeMultiple(dp[i - 1], 9);
        } else {
          dp[i + 1] += dp[i - 1];
        }
      } else if (prevChar == '2') {
        if (chr == '*') {
          dp[i + 1] += safeMultiple(dp[i - 1], 6);
        } else if (chr <= '6') {
          dp[i + 1] += dp[i - 1];
        }
      }
      dp[i + 1] %= MOD;
    }

    return dp[s.length()];
  }


  private static int safeMultiple(int base, int scale) { // using this can be really slow
    int res = 0;
    while (scale-- > 0) {
      res = (res + base) % MOD;
    }
    return res;
  }
}
