package _501_550._544_Output_Contest_Matches;

/**
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class Solution {

  public String findContestMatch(int n) {
    final String[] match = new String[n];
    for (int i = 1; i <= n; i++) {
      match[i - 1] = String.valueOf(i);
    }

    int left = 0, right = n - 1;
    while (right - left != 0) {

      while (left < right) {
        match[left] = getStringPair(match[left], match[right]);
        left++;
        right--;
      }
      right = left - 1;
      left = 0;
    }

    return match[0];
  }

  private String getStringPair(String str1, String str2) {
    return new StringBuilder().append("(").
        append(str1).append(",").append(str2).append(")").toString();
  }
}
