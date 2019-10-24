package _0001_0050._046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/25/2017.
 */
public final class SwapSolution implements Solution {

  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    final List<Integer> curPath = new ArrayList<>();
    for (int num : nums) {
      curPath.add(num);
    }
    permutation(result, curPath, 0);
    return result;
  }

  private static void permutation(final List<List<Integer>> result, final List<Integer> curPath, final int start) {
    if (start == curPath.size()) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < curPath.size(); i++) {
      swap(curPath, i, start);
      permutation(result, curPath, start + 1);
      swap(curPath, i, start);
    }
  }

  private static void swap(final List<Integer> curPath, final int i, final int j) {
    final int tmp = curPath.get(i);
    curPath.set(i, curPath.get(j));
    curPath.set(j, tmp);
  }
}
