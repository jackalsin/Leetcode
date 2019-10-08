package interviews.pureStorage._0647_Palindromic_Substrings;

/**
 * @author jacka
 * @version 1.0 on 10/7/2019
 */
public final class SolutionI implements Solution {
  private int count = 0;

  public int countSubstrings(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    for (int i = 0; i < s.length(); ++i) {
      expand(s, i, i);
      expand(s, i, i + 1);
    }
    return count;
  }

  private void expand(final String s, int left, int right) {
    for (; left >= 0 && right < s.length(); left--, right++) {
      final char leftChar = s.charAt(left), rightChar = s.charAt(right);
      if (leftChar != rightChar) break;
      count++;
    }
  }
}
