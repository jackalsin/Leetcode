package newsbreak._046_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 9/30/2020
 */
public final class SwapSolution implements Solution {
  @Override
  public List<List<Integer>> permute(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    final List<Integer> curPath = Arrays.stream(nums).boxed().collect(Collectors.toList());
    dfs(result, curPath, 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final List<Integer> curPath, final int start) {
    if (start == curPath.size()) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < curPath.size(); ++i) {
      swap(curPath, start, i);
      dfs(result, curPath, start + 1);
      swap(curPath, start, i);
    }
  }

  private static void swap(final List<Integer> list, final int i, final int j) {
    final int tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }
}
