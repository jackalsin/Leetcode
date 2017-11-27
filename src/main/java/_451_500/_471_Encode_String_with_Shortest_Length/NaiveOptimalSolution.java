package _451_500._471_Encode_String_with_Shortest_Length;

/**
 * This solution reference: https://discuss.leetcode.com/topic/71963/accepted-solution-in-java. Time
 * complexity: O (N^3); Space complexity: O (N^2)
 *
 * @author jacka
 * @version 1.0 on 11/26/2017.
 */
public final class NaiveOptimalSolution implements Solution {

  @Override
  public String encode(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    final int N = s.length();
    final String[][] dp = new String[N][N];

    for (int l = 0; l < s.length(); l++) {
      for (int start = 0; start < s.length() - l; start++) {
        int end = start + l;
        final String subString = s.substring(start, end + 1);
        if (end - start < 4) {
          dp[start][end] = subString;
        } else {
          dp[start][end] = subString;
          for (int k = start; k < end; k++) {
            String target = dp[start][k] + dp[k + 1][end];
            if (dp[start][end].length() > (target.length())) {
              dp[start][end] = target;
            }
          } // end of k loop

          for (int repeatEnd = 0; repeatEnd < subString.length(); repeatEnd++) {
            final String repeatString = subString.substring(0, repeatEnd + 1);
            if ((subString.length() % repeatString.length() == 0)
                // check if it's a repeated string
                && (subString.replaceAll(repeatString, "").length() == 0)
                ) {
              final String candidate = (subString.length() / repeatString.length()) + "["
//                  + repeatString
                  + dp[start][start + repeatEnd] // get already simplified version string
                  + "]";
              if (candidate.length() < dp[start][end].length()) {
                dp[start][end] = candidate;
              }
            }
          }
        }
      }
    }
//    display(dp); // display dp
    return dp[0][N - 1];
  }

}
