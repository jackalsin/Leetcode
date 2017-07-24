package _151_200._163_Missing_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    long start = lower;
    for (int i : nums) {
      if (i < start) {
        continue;
      }
      if (i == start) {
        start++;
        continue;
      }
      updateInterval(result, start, i - 1);
      start = i + 1L;
    }
    updateInterval(result, start, upper);
    return result;
  }

  /**
   *
   * @param result
   * @param start   inclusive
   * @param end     inclusive
   */
  private static void updateInterval(List<String> result, long start, long end) {
    if (end > start) {
      result.add(new StringBuilder().append(start).append("->").append(end).toString());
    } else if (end == start) {
      result.add(String.valueOf(start));
    }
  }
}
