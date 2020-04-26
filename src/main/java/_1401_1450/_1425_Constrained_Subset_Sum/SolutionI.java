package _1401_1450._1425_Constrained_Subset_Sum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class SolutionI implements Solution {

  /**
   * https://leetcode.com/problems/constrained-subset-sum/discuss/597693/Python-DP-with-decrease-deque
   */
  public int constrainedSubsetSum(int[] nums, int k) {
    final List<Integer> dp = new ArrayList<>();
    final Deque<Integer> q = new ArrayDeque<>();
    int res = nums[0];
    q.add(res); // non increasing deque, q.first() is the max of dp[i], dp[i - 1],..., dp[i - k]
    dp.add(res); // dp[i] max sum if including nums[i]
    for (int i = 1; i < nums.length; ++i) {
      if (i > k && q.peekFirst().equals(dp.get(i - k - 1))) {
        q.removeFirst();
      }
      final int tmp = Math.max(nums[i], q.peekFirst() + nums[i]);
      while (!q.isEmpty() && q.peekLast() < tmp) {
        q.removeLast();
      }
      q.addLast(tmp);
      dp.add(tmp);
      res = Math.max(res, tmp);
    }
    return res;
  }
}
