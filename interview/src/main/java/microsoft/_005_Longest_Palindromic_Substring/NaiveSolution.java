package microsoft._005_Longest_Palindromic_Substring;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public final class NaiveSolution implements Solution {
  @Override
  public String longestPalindrome(String s) {
    int[] res = {0, 0};
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      int[] oddRes = longestPalindrome(chars, i, i);
      if (res[1] - res[0] < oddRes[1] - oddRes[0]) {
        res = oddRes;
      }
      if (i >= 1) {
        int[] evenRes = longestPalindrome(chars, i - 1, i);
        if (res[1] - res[0] < evenRes[1] - evenRes[0]) {
          res = evenRes;
        }
      }
    }

    return s.substring(res[0], res[1] + 1);
  }

  static int[] longestPalindrome(final char[] chars, int left, int right) {
    int[] res = {left, left};
    while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
      res = new int[] {left, right};
      left--;
      right++;
    }
    return res;
  }
}
