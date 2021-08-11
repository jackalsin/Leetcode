package linkedin._151_Reverse_Words_in_a_String;

/**
 * @author jacka
 * @version 1.0 on 8/28/2019
 */
public final class SolutionV implements Solution {
  @Override
  public String reverseWords(String s) {
    if (s == null || s.isEmpty()) return s;
    final char[] chars = s.toCharArray();
    reverse(chars, 0, chars.length - 1);
    reverseWord(chars);
    return removeSpace(chars);
  }

  private static String removeSpace(final char[] chars) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; ) {
      sb.append(" ");
      while (i < chars.length && chars[i] == ' ') ++i;
      while (i < chars.length && chars[i] != ' ') sb.append(chars[i++]);
      while (i < chars.length && chars[i] == ' ') ++i;
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static void reverseWord(final char[] chars) {
    for (int i = 0; i < chars.length; ++i) {
      if (chars[i] == ' ') continue;
      final int start = i;
      while (i + 1 < chars.length && chars[i + 1] != ' ') {
        i++;
      }
      reverse(chars, start, i);
    }
  }

  /**
   * @param end inclusive
   */
  private static void reverse(final char[] chars, final int start, final int end) {
    for (int i = start, j = end; i < j; ++i, --j) {
      swap(chars, i, j);
    }
  }

  private static void swap(final char[] chars, final int i, final int j) {
    final char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }
}
