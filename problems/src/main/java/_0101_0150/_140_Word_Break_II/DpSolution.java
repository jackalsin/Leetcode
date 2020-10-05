package _0101_0150._140_Word_Break_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public final class DpSolution implements Solution {
  /**
   * Time Complexity: O(N^2)
   * Space Complexity: O(N)
   *
   * @param s
   * @param wordDict
   * @return
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    final Set<String> wordSet = new HashSet<>(wordDict);

    final List<Set<String>> dp = new ArrayList<>();
    for (int i = 0; i <= s.length(); i++) {
      dp.add(new HashSet<>());
    }
    dp.get(0).add("");
    for (int end = 1; end <= s.length(); end++) {
      for (int start = 0; start < end; start++) {
        final String substr = s.substring(start, end);
        if (wordSet.contains(substr)) {
          final Set<String> candidates = dp.get(start);
          for (final String candidate : candidates) {
            dp.get(end).add(candidate + " " + substr);
          }
        }
      }
    }

    final List<String> result = new ArrayList<>();
    final Set<String> resultSet = dp.get(dp.size() - 1);
    for (final String child : resultSet) {
      result.add(child.substring(1));
    }
    return result;
  }
}
