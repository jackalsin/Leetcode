package interviews.linkedin._541_Reverse_String_II;

/**
 * @author jacka
 * @version 1.0 on 8/11/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String reverseStr(String s, int k) {
    if (s == null || k <= 0) {
      return s;
    }
    final char[] chars = s.toCharArray();
    for (int start = 0; start < chars.length; start += 2 * k) {
      int left = start, right = Math.min(chars.length - 1, start + k - 1);
      for (; left < right; ++left, --right) {
        swap(chars, left, right);
      }
    }
    return String.valueOf(chars);
  }

  private static void swap(final char[] chars, final int left, final int right) {
    final char tmp = chars[left];
    chars[left] = chars[right];
    chars[right] = tmp;
  }
}
