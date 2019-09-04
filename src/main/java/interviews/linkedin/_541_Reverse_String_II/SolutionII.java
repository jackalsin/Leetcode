package interviews.linkedin._541_Reverse_String_II;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public String reverseStr(String s, int k) {
    if (s == null || s.length() == 0) {
      return s;
    }
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i += 2 * k) {
      reverse(chars, i, Math.min(chars.length - 1, i + k - 1));
    }
    return String.valueOf(chars);
  }

  private static void reverse(final char[] chars, int i, int j) {
    for (; i < j; ++i, --j) {
      final char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
    }
  }
}
