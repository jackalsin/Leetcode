package interviews.linkedin._046_Permutations;

import java.util.ArrayList;
import java.util.List;

public final class SwapSolution implements Solution {

  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    final List<Integer> curPath = new ArrayList<>();
    for (int num : nums) {
      curPath.add(num);
    }
    permute(result, curPath, 0);
    return result;
  }

  private static void permute(final List<List<Integer>> result, final List<Integer> curPath, int left) {
    if (left == curPath.size()) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    for (int i = left; i < curPath.size(); i++) {
      swap(curPath, i, left);
      permute(result, curPath, left + 1);
      swap(curPath, i, left);
    }
  }

  private static void swap(final List<Integer> curPath, int i, int j) {
    int tmp = curPath.get(i);
    curPath.set(i, curPath.get(j));
    curPath.set(j, tmp);
  }
}
