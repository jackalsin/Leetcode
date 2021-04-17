package uber.codeSignal._128_Longest_Consecutive_Sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public final class SortSolution implements Solution {
  @Override
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final Set<Integer> set = new HashSet<>();
    for (final int num : nums) {
      set.add(num);
    }
    final List<Integer> sorted = new ArrayList<>(set);
    Collections.sort(sorted);
    int max = 1;
    for (int cur = 1, i = 1; i < sorted.size(); ++i) {
      if (sorted.get(i - 1) + 1 == sorted.get(i)) {
        cur++;
        max = Math.max(cur, max);
      } else {
        cur = 1;
      }
    }
    return max;
  }
}
