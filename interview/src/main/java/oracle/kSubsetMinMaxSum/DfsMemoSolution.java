package oracle.kSubsetMinMaxSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2019
 */
public final class DfsMemoSolution implements Solution {
  private int min = Integer.MAX_VALUE;
  private final Set<List<List<Integer>>> cache = new HashSet<>();

  public int minMaxSum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    dfs(new ArrayList<>(), k, new int[k], nums, 0);
    return min;
  }

  private void dfs(final List<List<Integer>> state, final int k, final int[] sums, final int[] nums, final int index) {
    final List<List<Integer>> key = getDeepCopy(state);
    normalize(key);
    if (cache.contains(key)) {
      return;
    }
    cache.add(key);
    if (index == nums.length) {
      int max = Integer.MIN_VALUE;
      for (int sum : sums) {
        max = Math.max(sum, max);
      }
      min = Math.min(max, min);
      return;
    }
    final int num = nums[index];
    for (int i = 0; i < state.size(); i++) {
      final List<Integer> curBucket = state.get(i);
      curBucket.add(num);
      sums[i] += num;
      dfs(state, k, sums, nums, index + 1);
      sums[i] -= num;
      curBucket.remove(curBucket.size() - 1);
    }
    if (k > state.size()) {
      final int i = state.size();
      final List<Integer> newBucket = new ArrayList<>();
      newBucket.add(num);
      state.add(newBucket);
      sums[i] += num;
      dfs(state, k, sums, nums, index + 1);
      sums[i] -= num;
      state.remove(state.size() - 1);
    }
  }

  private static void normalize(final List<List<Integer>> state) {
    state.sort((l1, l2) -> {
      final int size1 = l1.size(), size2 = l2.size(), sizeCmp = Integer.compare(size1, size2);
      if (sizeCmp == 0) {
        for (int i = 0; i < l1.size(); ++i) {
          final int cmp = Integer.compare(l1.get(i), l2.get(i));
          if (cmp != 0) {
            return cmp;
          }
        }
      }
      return sizeCmp;
    });
  }

  private static List<List<Integer>> getDeepCopy(final List<List<Integer>> state) {
    final List<List<Integer>> result = new ArrayList<>();
    for (List<Integer> s : state) {
      result.add(new ArrayList<>(s));
    }
    return result;
  }
}
