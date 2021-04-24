package google._282_Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/23/2021
 */
public final class SolutionI implements Solution {
  private static final char PLUS = '+', MINUS = '-', MUL = '*';

  public List<String> addOperators(String num, int target) {
    final List<String> result = new ArrayList<>();
    addOperators(result, num, target, new StringBuilder(), 0, 0, 1, 1);
    return result;
  }

  private void addOperators(final List<String> result, final String num, final long target, final StringBuilder sb,
                            final int start, final long l1, final int o1, final long l2) {
    if (start == num.length()) {
      if (l1 + o1 * l2 == target) {
        result.add(sb.toString());
      }
      return;
    }
    final int len = num.length(), sbLength = sb.length();
    long cur = 0;
    for (int i = start; i < len; ++i) {
      if (i > start && num.charAt(start) - '0' == 0) break;
      cur = cur * 10 + num.charAt(i) - '0';
      if (sbLength == 0) {
        sb.append(cur);
        addOperators(result, num, target, sb, i + 1, l1, 1, cur);
        sb.setLength(sbLength);
      } else {
        sb.append(PLUS).append(cur);
        addOperators(result, num, target, sb, i + 1, l1 + o1 * l2, 1, cur);
        sb.setLength(sbLength);
        sb.append(MINUS).append(cur);
        addOperators(result, num, target, sb, i + 1, l1 + o1 * l2, -1, cur);
        sb.setLength(sbLength);
        sb.append(MUL).append(cur);
        addOperators(result, num, target, sb, i + 1, l1, o1, cur * l2);
        sb.setLength(sbLength);
      }
    }
  }
}
