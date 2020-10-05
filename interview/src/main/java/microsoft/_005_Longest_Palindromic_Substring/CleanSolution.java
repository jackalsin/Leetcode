package microsoft._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public final class CleanSolution implements Solution {
  private int[] res = {0, 0};

  @Override
  public String longestPalindrome(String s) {
    for (int i = 0; i < s.length() - 1; i++) {
      extend(s, i, i);
      extend(s, i, i + 1);
    }
    return s.substring(res[0], res[1] + 1);
  }

  private void extend(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      if (res[1] - res[0] < (right - left)) {
        res = new int[] {left, right};
      }
      left--;
      right++;
    }
  }
}
