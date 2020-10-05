package linkedin._151_Reverse_Words_in_a_String;

public final class SolutionI implements Solution {

  public String reverseWords(String s) {
    final char[] chars = s.toCharArray();
    int len = 0;
    // remove leading space
    for (int i = 0; i < chars.length; ++i) {
      if (chars[i] == ' ') {
        if (len == 0) {
          continue;
        }
        if (chars[len - 1] == ' ') {
          continue;
        }
      }
      chars[len++] = chars[i];
    }
    // to prevent fails on "1 "
    if (len > 0 && chars[len - 1] == ' ') {
      len--;
    }

    reverse(chars, 0, len - 1);
    for (int end = 0; end < len; end++) {
      if (chars[end] != ' ') {
        final int start = end;
        while (end + 1 < len && chars[end + 1] != ' ') {
          end++;
        }
        reverse(chars, start, end);
      }
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      sb.append(chars[i]);
    }
    return sb.toString();
  }

  private static void reverse(final char[] chars, int start, int end) {
    while (start < end) {
      final char chr = chars[start];
      chars[start] = chars[end];
      chars[end] = chr;
      start++;
      end--;
    }
  }
}
