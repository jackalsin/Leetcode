package interviews.linkedin._647_Palindromic_Substrings;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionI implements Solution {
  private int count;

  /**
   * TODO: Revisited
   *
   * @param s
   * @return
   */
  public int countSubstrings(String s) {
    count = 0;
    for (int i = 0; i < s.length(); i++) {
      extendString(s, i, i);
      extendString(s, i, i + 1);
    }
    return count;
  }

  private void extendString(String s, int left, int right) {
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left--) == s.charAt(right++)) {
        count++;
      } else {
        return;
      }
    }
  }
}
