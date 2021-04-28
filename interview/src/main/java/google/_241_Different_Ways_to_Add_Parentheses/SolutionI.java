package google._241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/27/2021
 */
public final class SolutionI implements Solution {
  private final Map<Long, List<Integer>> cache = new HashMap<>();
  private static final char PLUS = '+', MINUS = '-', MUL = '*';

  public List<Integer> diffWaysToCompute(String expression) {
    return diffWaysToCompute(expression, 0, expression.length() - 1);
  }

  private List<Integer> diffWaysToCompute(final String expression, final int left, final int right) {
    assert right >= left;
    final long key = (long) left << 32 | right;
    if (cache.containsKey(key)) return cache.get(key);
    final List<Integer> result = new ArrayList<>();
    for (int i = left; i <= right; ++i) {
      final char chr = expression.charAt(i);
      if (chr == PLUS || chr == MINUS || chr == MUL) {
        final List<Integer> leftResult = diffWaysToCompute(expression, left, i - 1),
            rightResult = diffWaysToCompute(expression, i + 1, right);
        for (int l : leftResult) {
          for (int r : rightResult) {
            if (chr == PLUS) {
              result.add(l + r);
            } else if (chr == MINUS) {
              result.add(l - r);
            } else {
              result.add(l * r);
            }
          }
        } // end of left for loop
      }
    }
    if (result.isEmpty()) {
      result.add(Integer.parseInt(expression.substring(left, right + 1).trim()));
    }
    cache.put(key, result);
    return result;
  }
}
