package uber._078_Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/17/2018.
 */
public class Solution {
  /**
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    dfsHelper(result, nums, new ArrayList<>(), 0);
    return result;
  }

  private void dfsHelper(final List<List<Integer>> result, final int[] nums, final List<Integer> curPath, int start) {
    result.add(new ArrayList<>(curPath));
    for (int i = start; i < nums.length; i++) {
      curPath.add(nums[i]);
      dfsHelper(result, nums, curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
