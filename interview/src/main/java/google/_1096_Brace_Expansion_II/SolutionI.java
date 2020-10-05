package google._1096_Brace_Expansion_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> braceExpansionII(String expressionStr) {
    Set<String> curLevel = new HashSet<>(), result = new HashSet<>();
    final Deque<Set<String>> stack = new ArrayDeque<>();
    final char[] expression = expressionStr.toCharArray();
    for (int i = 0; i < expression.length; ++i) {
      final char chr = expression[i];
      if (Character.isAlphabetic(chr)) {
        final StringBuilder sb = new StringBuilder().append(expression[i]);
        while (i + 1 < expression.length && Character.isAlphabetic(expression[i + 1])) {
          sb.append(expression[i + 1]);
          ++i;
        }
        curLevel = multiply(curLevel, Collections.singleton(sb.toString()));
      } else if (chr == '{') {
        stack.push(curLevel);
        stack.push(result);
        curLevel = new HashSet<>();
        result = new HashSet<>();
      } else if (chr == '}') {
        final Set<String> prevRes = stack.pop(), prevCur = stack.pop();
        result.addAll(curLevel);
        curLevel = multiply(prevCur, result);
        result = prevRes;
      } else if (chr == ',') {
        result.addAll(curLevel);
        curLevel = new HashSet<>();
      }
    }
    result.addAll(curLevel);
    final List<String> sorted = new ArrayList<>(result);
    Collections.sort(sorted);
    return sorted;
  }

  private static Set<String> multiply(final Set<String> set1, final Set<String> set2) {
    final Set<String> result = new HashSet<>();
    if (set1.isEmpty()) set1.add("");
    for (final String s1 : set1) {
      for (final String s2 : set2) {
        result.add(s1 + s2);
      }
    }
    return result;
  }
}
