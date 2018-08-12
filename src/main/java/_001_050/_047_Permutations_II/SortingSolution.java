package _001_050._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 2/26/17.
 */
public final class SortingSolution implements Solution {
  /**
   * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
   * Time Complexity: O(n! * n)
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(nums); // n log n
    List<List<Integer>> result = new ArrayList<>();
    permuteUniqueHelper(result, new ArrayList<>(), new boolean[nums.length], nums);
    return result;
  }

  private static void permuteUniqueHelper(final List<List<Integer>> result, final List<Integer> curPath, final boolean[] used,
                                          final int[] nums) {
    if (curPath.size() == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
      used[i] = true;
      curPath.add(nums[i]);
      permuteUniqueHelper(result, curPath, used, nums);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
