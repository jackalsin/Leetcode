package interviews.linkedin._151_Reverse_Words_in_a_String;

/**
 * @author jacka
 * @version 1.0 on 8/28/2019
 */
public final class SolutionV implements Solution {
  @Override
  public String reverseWords(String s) {
    if (s == null) {
      return null;
    }
    final char[] chars = s.toCharArray();
    reverse(chars, 0, chars.length - 1);
    reverserWords(chars);
    return removeSpaces(chars);
  }

  private static String removeSpaces(final char[] chars) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; ) {
      while (i < chars.length && chars[i] == ' ') i++;
      sb.append(" ");
      // i point non space
      while (i < chars.length && chars[i] != ' ') sb.append(chars[i++]);
      while (i < chars.length && chars[i] == ' ') i++;
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static void reverserWords(final char[] chars) {
    for (int end = 0; end < chars.length; ++end) {
      if (chars[end] == ' ') continue;
      final int start = end;
      while (end + 1 < chars.length && chars[end + 1] != ' ') {
        end++;
      }
      reverse(chars, start, end);
    }
  }

  private static void reverse(final char[] chars, int i, int j) {
    for (; i < j; ++i, --j) {
      final char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
    }
  }
}
