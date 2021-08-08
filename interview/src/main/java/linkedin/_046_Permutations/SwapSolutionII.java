package linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SwapSolutionII implements Solution {

  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    final List<Integer> cur = Arrays.stream(nums).boxed().collect(Collectors.toList());
    permute(result, cur, 0);
    return result;
  }

  private static void permute(final List<List<Integer>> result, final List<Integer> cur, final int start) {
    if (start == cur.size()) {
      result.add(new ArrayList<>(cur));
      return;
    }
    for (int i = start; i < cur.size(); ++i) {
      swap(cur, i, start);
      permute(result, cur, start + 1);
      swap(cur, i, start);
    }
  }

  private static void swap(final List<Integer> nums, final int i, final int j) {
    final int tmp = nums.get(i);
    nums.set(i, nums.get(j));
    nums.set(j, tmp);
  }
}
