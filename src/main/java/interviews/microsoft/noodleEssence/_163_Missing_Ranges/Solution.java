package interviews.microsoft.noodleEssence._163_Missing_Ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    long prev = lower;
    final List<String> result = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      final long next = i == nums.length ? upper : nums[i] - 1L;
      final String interval = getInterval(prev, next);
      if (interval != null) {
        result.add(interval);
      }
      prev = next + 2;
    }
    return result;
  }

  /**
   * @param start inclusive
   * @param end   inclusive
   * @return
   */
  private static String getInterval(long start, long end) {
    if (start > end) {
      return null;
    } else if (start == end) {
      return String.valueOf(start);
    } else {
      return start + "->" + end;
    }
  }
}
