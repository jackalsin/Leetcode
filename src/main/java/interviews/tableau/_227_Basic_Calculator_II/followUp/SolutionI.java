package interviews.tableau._227_Basic_Calculator_II.followUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Integer> values = new HashMap<>();
  private final Map<Integer, String> replaces = new HashMap<>();
  private static final char A = 'A';

  public List<String> calculate(List<String> input) {
    final List<String> result = new ArrayList<>();
    for (int i = 0; i < input.size(); ++i) {
      final boolean isRef = eval(input, i);
      final StringBuilder sb = new StringBuilder().append(values.get(i));
      if (isRef) {
        sb.append("(")
            .append(replaces.get(i))
            .append(")");
      }
      result.add(sb.toString());
    }
    return result;
  }

  private boolean eval(final List<String> input, final int inputIndex) {
    final String s = input.get(inputIndex);
    final char[] chars = s.toCharArray();
    final StringBuilder afterEval = new StringBuilder();
    boolean isRef = false;
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    for (int end = 0; end < chars.length; ++end) {
      final char chr = chars[end];
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (end + 1 < chars.length && Character.isDigit(chars[end + 1])) {
          num = num * 10 + chars[end + 1] - '0';
          end++;
        }
        l2 = o2 == 1 ? (l2 * num) : (l2 / num);
        afterEval.append(num);
      } else if (chr == A) { // replace
        int numIndex = 0;
        while (end + 1 < chars.length && Character.isDigit(chars[end + 1])) {
          numIndex = numIndex * 10 + chars[end + 1] - '0';
          end++;
        }
        eval(input, numIndex);
        final int num = values.get(numIndex);
        l2 = o2 == 1 ? (l2 * num) : (l2 / num);
        afterEval.append(values.get(numIndex));
        isRef = true;
      } else {
        if (chr == '-' || chr == '+') {
          l1 = l1 + o1 * l2;
          o1 = chr == '+' ? 1 : -1;
          l2 = 1;
          o2 = 1;
        } else if (chr == '*' || chr == '/') {
          o2 = chr == '*' ? 1 : -1;
        }
        afterEval.append(chr);
      }
    } // end of end for loop
    final int res = l1 + o1 * l2;
    values.put(inputIndex, res);
    if (isRef) {
      replaces.put(inputIndex, afterEval.toString());
    } else {
      replaces.put(inputIndex, Integer.toString(res));
    }
    return isRef;
  }
}
