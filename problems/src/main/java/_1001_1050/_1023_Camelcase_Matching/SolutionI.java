package _1001_1050._1023_Camelcase_Matching;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Boolean> camelMatch(String[] queries, String pattern) {
    final List<Boolean> result = new ArrayList<>();
    for (final String q : queries) {
      result.add(isMatch(q.toCharArray(), pattern.toCharArray()));
    }
    return result;
  }

  private static boolean isMatch(final char[] str, final char[] pattern) {
    int j = 0, i = 0;
    for (; i < str.length; ++i) {
      if (j < pattern.length && pattern[j] == str[i]) {
        j++;
      } else if (Character.isUpperCase(str[i])) {
        return false;
      }
    }

    return j == pattern.length;
  }
}
