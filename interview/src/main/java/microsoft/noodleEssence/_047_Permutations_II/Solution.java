package microsoft.noodleEssence._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    final List<List<Integer>> result = new ArrayList<>();
    permuteUnique(result, new ArrayList<>(), nums, new boolean[nums.length], 0);
    return result;
  }

  private void permuteUnique(final List<List<Integer>> result, final List<Integer> curPath,
                             final int[] nums, final boolean[] used, final int start) {
    if (start == nums.length) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
        continue;
      }
      used[i] = true;
      curPath.add(nums[i]);
      permuteUnique(result, curPath, nums, used, start + 1);
      curPath.remove(curPath.size() - 1);
      used[i] = false;
    }
  }
}
