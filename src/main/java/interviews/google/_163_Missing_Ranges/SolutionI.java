package interviews.google._163_Missing_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    final List<String> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    final int n = nums.length;
    for (int i = 0; i <= n; ++i) {
      final long start = i == 0 ? Long.MIN_VALUE : nums[i - 1],
          end = i == n ? Long.MAX_VALUE : nums[i];
      final String toAdd = getInterval(Math.max(start + 1, lower), Math.min(upper, end - 1));
      if (toAdd.isEmpty()) continue;
      result.add(toAdd);
    }
    return result;
  }

  private static String getInterval(final long left, final long right) {
    if (left > right) {
      return "";
    }
    if (left == right) {
      return String.valueOf(left);
    }
    return new StringBuilder().append(left).append("->").append(right).toString();
  }
}
