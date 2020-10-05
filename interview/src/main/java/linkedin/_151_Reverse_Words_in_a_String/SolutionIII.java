package linkedin._151_Reverse_Words_in_a_String;

public final class SolutionIII implements Solution {

  public String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    final char[] chars = s.toCharArray();
    for (int end = 0; end < chars.length; end++) {
      if (chars[end] == ' ') {
        continue;
      }
      int start = end;
      while (end + 1 < chars.length && chars[end + 1] != ' ') {
        end++;
      }
      reverse(chars, start, end);
    }
    reverse(chars, 0, s.length() - 1);
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
      if (chars[i] == ' ' && (len == 0 || chars[len - 1] == ' ')) {
        continue;
      }
      chars[len++] = chars[i];
    }
    if (len > 0 && chars[len - 1] == ' ') {
      len--;
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      sb.append(chars[i]);
    }
    return sb.toString();
  }

  private static void reverse(final char[] chars, int left, int right) {
    while (left < right) {
      final char tmp = chars[left];
      chars[left] = chars[right];
      chars[right] = tmp;
      left++;
      right--;
    }
  }
}
