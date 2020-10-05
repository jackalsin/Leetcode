package linkedin._344_Reverse_String;

/**
 * @author jacka
 * @version 1.0 on 8/11/2019
 */
public final class SolutionI implements Solution {
  @Override
  public void reverseString(char[] s) {
    if (s == null) {
      return;
    }

    for (int left = 0, right = s.length - 1; left < right; ++left, --right) {
      final char tmp = s[left];
      s[left] = s[right];
      s[right] = tmp;
    }
  }
}
