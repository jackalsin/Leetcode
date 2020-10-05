package linkedin._151_Reverse_Words_in_a_String;

public final class SolutionII implements Solution {

  public String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    final char[] chars = s.toCharArray();
    for (int end = 0; end < s.length(); end++) {
      if (chars[end] == ' ') {
        continue;
      } else {
        final int start = end;
        while (end + 1 < s.length() && chars[end + 1] != ' ') {
          end++;
        }
        reverse(chars, start, end);
      }
    }

    reverse(chars, 0, s.length() - 1);

    int len = 0;
    for (int j = 0; j < s.length(); j++) {
      if (chars[j] == ' ' && (len == 0 || chars[len - 1] == ' ')) {
        continue;
      }
      chars[len++] = chars[j];
    }
    if (len > 0 && chars[len - 1] == ' ') {
      len--;
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; ++i) {
      sb.append(chars[i]);
    }
    return sb.toString();
  }

  /**
   * @param chars
   * @param start inclusive
   * @param end   inclusive
   */
  private static void reverse(final char[] chars, int start, int end) {
    while (start < end) {
      final char tmp = chars[start];
      chars[start] = chars[end];
      chars[end] = tmp;
      start++;
      end--;
    }
  }
}
