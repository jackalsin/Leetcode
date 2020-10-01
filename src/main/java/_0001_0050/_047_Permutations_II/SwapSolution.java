package _0001_0050._047_Permutations_II;

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
  public List<List<Integer>> permuteUnique(int[] nums) {
    final List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    final List<Integer> curPath = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
    dfs(result, curPath, 0);
    return result;
  }

  private static void dfs(final List<List<Integer>> result, final List<Integer> curPath, final int start) {
    if (start == curPath.size()) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = start; i < curPath.size(); ++i) {
      if (i > start && curPath.get(i).equals(curPath.get(start))) {
        continue;
      }
      /*  先说说为什么这么做是对的:
       *  每次在start上的都是一个different value，但是我们要保持sorted order才能保证之前的skip是成功的
       *  所以我们被迫每次defensive copy一份curPath
       * */
      swap(curPath, i, start);
      dfs(result, new ArrayList<>(curPath), start + 1);
//      swap(curPath, i, start);
    }
  }

  private static void swap(final List<Integer> list, final int i, final int j) {
    final int tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }
}
