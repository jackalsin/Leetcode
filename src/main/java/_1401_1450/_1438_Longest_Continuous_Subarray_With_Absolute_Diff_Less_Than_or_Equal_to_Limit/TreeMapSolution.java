package _1401_1450._1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;


import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public final class TreeMapSolution implements Solution {
  private int max = 0;

  public int longestSubarray(int[] nums, int limit) {
    helper(nums, limit, 0, new TreeMap<>(), 0);
    return max;
  }

  private void helper(final int[] nums, final int limit, int minStart,
                      final TreeMap<Integer, Integer> count, final int i) {
    if (i == nums.length) {
      return;
    }
    // remove small
    if (!count.isEmpty() && count.firstKey() + limit < nums[i]) {
      final Map<Integer, Integer> toRemove = count.subMap(0, false, nums[i] - limit, false);
      for (final var e : new HashSet<>(toRemove.entrySet())) {
        final int start = e.getKey();
        // TODO: look back
        minStart = Math.max(minStart, e.getValue() + 1);
        count.remove(start);
      }
    }

    if (!count.isEmpty() && count.lastKey() - limit > nums[i]) {
      final Map<Integer, Integer> toRemove = count.subMap(nums[i] + limit, false, Integer.MAX_VALUE, false);
      for (final var e : new HashSet<>(toRemove.entrySet())) {
        final int start = e.getKey();
        minStart = Math.max(minStart, e.getValue() + 1);
        count.remove(start);
      }
    }

    count.put(nums[i], i);
    max = Math.max(max, i - minStart + 1);
//    System.out.println("max = " + max + ", start = " + minStart);
    helper(nums, limit, minStart, count, i + 1);
  }
}
