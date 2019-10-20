package interviews.oracle._394_Decode_String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String decodeString(String s) {
    final Deque<String> strStack = new ArrayDeque<>();
    final Deque<Integer> countStack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        countStack.push(num);
      } else if (chr == '[') {
        strStack.push(sb.toString());
        sb.setLength(0);
      } else if (chr == ']') {
        final StringBuilder newSb = new StringBuilder(strStack.pop());
        final int repeat = countStack.pop();
        for (int r = 0; r < repeat; r++) {
          newSb.append(sb);
        }
        sb = newSb;
      } else {
        sb.append(chr);
      }
    }
    return sb.toString();
  }
}
