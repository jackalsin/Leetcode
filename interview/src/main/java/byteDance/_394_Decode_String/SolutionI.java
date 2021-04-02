package byteDance._394_Decode_String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 4/1/2021
 */
public final class SolutionI implements Solution {
  private static final char LEFT = '[',
      RIGHT = ']';

  public String decodeString(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    final int n = s.length();
    final char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    final Deque<Integer> countStack = new ArrayDeque<>();
    final Deque<StringBuilder> patternStack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      final char chr = chars[i];
      if (Character.isDigit(chr)) {
        int count = chr - '0';
        while (i + 1 < n && Character.isDigit(chars[i + 1])) {
          count = count * 10 + chars[i + 1] - '0';
          i++;
        }
        count = Math.max(count, 1);
        countStack.push(count);
      } else if (chr == LEFT) {
        patternStack.push(sb);
        sb = new StringBuilder();
      } else if (chr == RIGHT) {
        final StringBuilder prev = patternStack.pop();
        final int count = countStack.pop();
        for (int c = 0; c < count; ++c) {
          prev.append(sb);
        }
        sb = prev;
      } else {
        sb.append(chr);
      }
    }
    return sb.toString();
  }
}
