package _0601_0650._647_Palindromic_Substrings;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class ONSquareSolution implements Solution {
  private int count;

  public int countSubstrings(String s) {
    count = 0;
    if (s == null) {
      return count; // necessary
    }
    for (int mid = 0; mid < s.length(); ++mid) {
      extendFromMid(s, mid, mid);
      extendFromMid(s, mid, mid + 1);
    }
    return count;
  }

  private void extendFromMid(final String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      count++;
      left--;
      right++;
    }
  }
}
