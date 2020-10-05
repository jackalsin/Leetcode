package _0451_0500._494_Target_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * The key is not unique.
 * See details on https://discuss.leetcode.com/topic/76245/java-simple-dfs-with-memorization
 */
public class DfsWrongSolution implements Solution {
  @Override
  public int findTargetSumWays(int[] nums, int S) {
    final Map<Integer, Integer> cache = new HashMap<>();
    int res = dfs(cache, S, nums, 0, 0, 0);
    return res;
  }

  private int dfs(Map<Integer, Integer> cache, final int S, final int[] nums, int index, int sum, int key) {
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    if (nums.length == index) {
      if (S == sum) {
        return 1;
      } else {
        return 0;
      }
    }
    int curNum = nums[index];
    int add = dfs(cache, S, nums, index + 1, sum + curNum, (key << 1) + 1);
    int minus = dfs(cache, S, nums, index + 1, sum - curNum, (key << 1) + 0);
    cache.put(key, add + minus);
    return add + minus;
  }
}
