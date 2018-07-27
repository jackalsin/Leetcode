package _451_500._471_Encode_String_with_Shortest_Length;

import utils.TwoDimensionArray;

/**
 * @author jacka
 * @version 1.0 on 11/27/2017.
 */
public class ONCubicSolution implements Solution {
  @Override
  public String encode(String s) {
    int n = s.length();
    String[][] dp = new String[n][n];
    for (int j = 0; j < n; ++j) {
      int i = j;
      dp[i][j] = s.substring(j, j + 1);
      for (int p = 0; p < i; ++p) {
        dp[p][j] = dp[p][j - 1] + dp[i][j];
      }
      for (i = j - 1; i + 1 >= j - i; --i) {
        String sub = s.substring(i + 1, j + 1); // s[i+1..j]
        for (int k = i - (j - i) + 1; k >= 0 && sub.equals(s.substring(k, k + j - i)); k -= j - i) {
          String str = Integer.toString((j + 1 - k) / (j - i)) + "[" + dp[i + 1][j] + "]";
          if (str.length() < dp[k][j].length()) {
            dp[k][j] = str;
            for (int p = 0; p < k; ++p) {
              if (dp[p][k - 1].length() + str.length() < dp[p][j].length()) {
                dp[p][j] = dp[p][k - 1] + str;
              }
            }
          }
        }
      }
      TwoDimensionArray.display(dp);
    }
    return dp[0][n - 1];
  }
}
