package interviews.linkedin._151_Reverse_Words_in_a_String;

/**
 * @author jacka
 * @version 1.0 on 8/4/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public String reverseWords(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    final char[] chars = s.toCharArray();
    reverse(chars, 0, s.length() - 1);
    reverseWord(chars);
    return removeSpace(chars);
  }

  private static String removeSpace(final char[] chars) {
    final StringBuilder sb = new StringBuilder();
    // remove additional space
    int i = 0, j = 0;
    while (j < chars.length) {
      sb.append(" ");
      while (j < chars.length && chars[j] == ' ') j++; // skip space
      while (j < chars.length && chars[j] != ' ') sb.append(chars[j++]);
      while (j < chars.length && chars[j] == ' ') j++; // skip space
    }
    return sb.length() == 0 ? "" : sb.substring(1);
  }

  private static void reverseWord(final char[] chars) {
    for (int end = 0; end < chars.length; end++) {
      final char chr = chars[end];
      if (chr == ' ') continue;
      final int start = end;
      while (end + 1 < chars.length && chars[end + 1] != ' ') {
        end++;
      }
      reverse(chars, start, end);
    }
  }

  private static void reverse(final char[] chars, int i, int j) {
    while (i < j) {
      final char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;
      i++;
      j--;
    }
  }
}
