package linkedin._078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/4/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public List<List<Integer>> subsets(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    subsets(result, new ArrayList<>(), nums, 0);
    return result;
  }

  private static void subsets(final List<List<Integer>> result,
                              final List<Integer> curPath, final int[] nums, final int start) {
    if (start == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    subsets(result, curPath, nums, start + 1);
    curPath.add(nums[start]);
    subsets(result, curPath, nums, start + 1);
    curPath.remove(curPath.size() - 1);
  }
}
