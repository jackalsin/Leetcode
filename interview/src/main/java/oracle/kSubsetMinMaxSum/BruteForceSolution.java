package oracle.kSubsetMinMaxSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2019
 */
public final class BruteForceSolution implements Solution {
  private int min = Integer.MAX_VALUE;

  public int minMaxSum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < k; ++i) {
      result.add(new ArrayList<>());
    }
    dfs(result, new int[k], nums, 0);
    return min;
  }

  private void dfs(final List<List<Integer>> result, final int[] sums, final int[] nums, final int index) {
    if (index == nums.length) {
      int max = Integer.MIN_VALUE;
      for (int sum : sums) {
        max = Math.max(sum, max);
      }
      min = Math.min(min, max);
      return;
    }
    for (int i = 0; i < result.size(); ++i) {
      final int num = nums[index];
      final List<Integer> cur = result.get(i);
      sums[i] += num;
      cur.add(num);
      dfs(result, sums, nums, index + 1);
      sums[i] -= num;
      cur.remove(cur.size() - 1);
    }
  }
}
