package _0651_0700._697_Degree_of_an_Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findShortestSubArray(int[] nums) {
    final Map<Integer, List<Integer>> valToIndex = new HashMap<>();
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int max = 0;
    final Set<Integer> maxVals = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      valToIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
      final int cur = valToIndex.get(nums[i]).size();
      if (cur >= max) {
        if (cur > max) {
          max = cur;
          maxVals.clear();
        }
        maxVals.add(nums[i]);
      }
    }
    assert max != 0;
    if (max == 1) {
      return 1;
    }
    int res = nums.length;
    for (final int k : maxVals) {
      final List<Integer> curList = valToIndex.get(k);
      res = Math.min( curList.get(curList.size()  - 1) - curList.get(0) + 1, res);
    }
    return res;
  }
}
