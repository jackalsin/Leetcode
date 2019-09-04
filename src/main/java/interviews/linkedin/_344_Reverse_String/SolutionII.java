package interviews.linkedin._344_Reverse_String;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public void reverseString(char[] s) {
    if (s == null) {
      return;
    }
    for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
      final char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
    }
  }
}
