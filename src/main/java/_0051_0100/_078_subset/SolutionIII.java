package _0051_0100._078_subset;

import java.util.ArrayList;
import java.util.List;

public final class SolutionIII implements Solution {
  @Override
  public List<List<Integer>> subsets(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      final List<List<Integer>> resultCopy = new ArrayList<>(result);
      for (List<Integer> cur : resultCopy) {
        final List<Integer> curCopy = new ArrayList<>(cur);
        curCopy.add(nums[i]);
        result.add(curCopy);
      }
    }
    return result;
  }
}
