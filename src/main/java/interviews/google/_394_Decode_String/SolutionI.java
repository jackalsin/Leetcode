package interviews.google._394_Decode_String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String decodeString(String s) {
    final Deque<Pair> stack = new ArrayDeque<>();
    int count = 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        stack.push(new Pair(sb, count));
        sb = new StringBuilder();
        count = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          count = count * 10 + s.charAt(i + 1) - '0';
          i++;
        }
      } else if (chr == '[') {
        continue;
      } else if (Character.isAlphabetic(chr)) {
        sb.append(chr);
      } else if (chr == ']') {
        stack.peek().sb.append(append(sb, count));
        final Pair p = stack.pop();
        sb = p.sb;
        count = p.repeat;
      }
    }
    return append(sb, count);
  }

  private String append(final StringBuilder toAdd, final int times) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < times; ++i) {
      sb.append(toAdd);
    }
    return sb.toString();
  }

  private static final class Pair {
    private final StringBuilder sb;
    private final int repeat;

    private Pair(StringBuilder sb, int repeat) {
      this.sb = sb;
      this.repeat = repeat;
    }


  }
}
