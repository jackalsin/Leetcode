package airbnb.maxProfitGivingABunchOfSchedules;

import definition.Interval;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 2/21/2019.
 */
public class Solution {

  /**
   * Time Complexity: O(NLogN)
   *
   * @param schedules
   * @return
   */
  public int maxProfit(final Interval[] schedules) {
    if (schedules == null || schedules.length == 0) {
      return 0;
    }
    Arrays.sort(schedules, (i, j) -> Integer.compare(i.end, j.end));
    final int[] maxProfits = new int[schedules.length];
    maxProfits[0] = schedules[0].end - schedules[0].start;
    int maxProfit = maxProfits[0];
    for (int i = 1; i < schedules.length; i++) {
      final Interval interval = schedules[i];

      // binary search found the insert point
      // find the element last smaller or equals to
      int left = 0, right = i - 1;

      while (left < right) {
        final int mid = left + (right - left + 1) / 2;
        if (schedules[mid].end <= interval.start) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      // check if it is
      if (schedules[left].end <= interval.start) {
        maxProfits[i] = maxProfits[left] + interval.end - interval.start;
      } else {
        maxProfits[i] = interval.end - interval.start;
      }
      maxProfit = Math.max(maxProfit, maxProfits[i]);
    }
    return maxProfit;
  }
}
