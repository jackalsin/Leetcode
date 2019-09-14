package interviews.linkedin._647_Palindromic_Substrings;

/**
 * @author jacka
 * @version 1.0 on 9/13/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public int countSubstrings(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      res += extend(s, i, i);
      res += extend(s, i, i + 1);
    }
    return res;
  }

  private static int extend(final String s, int left, int right) {
    int res = 0;
    for (; left >= 0 && right < s.length(); --left, ++right) {
      final char leftChar = s.charAt(left), rightChar = s.charAt(right);
      if (leftChar == rightChar) {
        ++res;
      } else {
        break;
      }
    }
    return res;
  }
}
