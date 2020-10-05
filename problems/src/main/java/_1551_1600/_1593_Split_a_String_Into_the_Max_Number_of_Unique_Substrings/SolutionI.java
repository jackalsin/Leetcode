package _1551_1600._1593_Split_a_String_Into_the_Max_Number_of_Unique_Substrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxUniqueSplit(String s) {
    return maxUniqueSplit(s, new HashSet<>());
  }

  private static int maxUniqueSplit(final String s, final Set<String> visited) {
    int max = 0;
    final int n = s.length();
    for (int i = 1; i <= n; ++i) {
      final String cur = s.substring(0, i);
      if (visited.add(cur)) {
        final int curMax = 1 + maxUniqueSplit(s.substring(i), visited);
        max = Math.max(max, curMax);
        visited.remove(cur);
      }
    }
    return max;
  }
}
