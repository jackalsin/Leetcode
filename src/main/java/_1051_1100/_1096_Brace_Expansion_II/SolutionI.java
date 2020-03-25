package _1051_1100._1096_Brace_Expansion_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/23/2020
 */
public final class SolutionI implements Solution {

  public List<String> braceExpansionII(String expression) {
    if (expression == null || expression.isEmpty()) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>(),
        curExpression = new ArrayList<>();
    final Deque<List<String>> stack = new ArrayDeque<>();
    final char[] chars = expression.toCharArray();
    for (int i = 0; i < chars.length; ++i) {
      final char chr = chars[i];
      if (Character.isLetter(chr)) {
        final StringBuilder sb = new StringBuilder().append(chr);
        while (i + 1 < chars.length && Character.isLetter(chars[i + 1])) {
          sb.append(chars[i + 1]);
          i++;
        }
        curExpression = append(curExpression, Collections.singletonList(sb.toString()));
      } else if (chars[i] == '{') {
        stack.push(result);
        stack.push(curExpression);
        result = new ArrayList<>();
        curExpression = new ArrayList<>();
      } else if (chars[i] == '}') { // current level 结束
        final List<String> prevExpression = stack.pop(),
            prevResult = stack.pop();
        result.addAll(curExpression);
        curExpression = append(prevExpression, result);
        result = prevResult;
      } else if (chars[i] == ',') { // 跟basic calculator一致，每到','那么每次遇到union一次
        result.addAll(curExpression);
        curExpression = new ArrayList<>();
      }
    }
    result.addAll(curExpression);
    result = new ArrayList<>(new HashSet<>(result));
    Collections.sort(result);
    return result;
  }

  private static List<String> append(final List<String> prevExpression, final List<String> curExpression) {
    final List<String> result = new ArrayList<>();
    if (prevExpression.isEmpty()) {
      prevExpression.add("");
    }
    for (final String prev : prevExpression) {
      for (final String cur : curExpression) {
        result.add(prev + cur);
      }
    }
    return result;
  }
}
