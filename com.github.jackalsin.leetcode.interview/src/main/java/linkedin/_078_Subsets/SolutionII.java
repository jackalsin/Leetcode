package linkedin._078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public List<List<Integer>> subsets(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    subsets(result, nums, new ArrayList<>(), 0);
    return result;
  }

  public static void subsets(final List<List<Integer>> result, final int[] nums, final List<Integer> curPath,
                             final int start) {
    result.add(new ArrayList<>(curPath));
    for (int i = start; i < nums.length; i++) {
      curPath.add(nums[i]);
      subsets(result, nums, curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
