package google.bricks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
public final class SolutionI implements Solution {
  public int numberOfWays(int[] nums, final int w, final int h) {
    if (nums == null || w <= 0 || h <= 0) return 0;
    Arrays.sort(nums);
    final List<Set<Integer>> combination = getCombination(nums, w);
//    System.out.println(combination);
    final Map<Integer, List<Integer>> parentToChildrenCounts = getParentToChildren(combination);
//    System.out.println(parentToChildrenCounts);
    final int n = combination.size();
    if (h == 1) return n;
    int[] prev = new int[n];
    Arrays.fill(prev, 1);
    int res = 0;
    for (int i = 1; i < h; ++i) {
      final int[] cur = new int[n];
      for (final var e : parentToChildrenCounts.entrySet()) {
        final int p = e.getKey();
        final List<Integer> children = e.getValue();
        for (int c : children) {
          cur[c] += prev[p];
          if (i == h - 1) {
            res += cur[c];
          }
        } // end of c
      } // end of e
      prev = cur;
//      System.out.println(Arrays.toString(prev));
    }
    return res;
  }

  private static Map<Integer, List<Integer>> getParentToChildren(final List<Set<Integer>> combinations) {
    final Map<Integer, List<Integer>> result = new HashMap<>();
    for (int i = 0; i < combinations.size(); ++i) {
      for (int j = i + 1; j < combinations.size(); ++j) {
        if (!hasIntersection(combinations.get(i), combinations.get(j))) {
          result.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
          result.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
        }
      }
    }
    return result;
  }

  private static boolean hasIntersection(final Set<Integer> s1, final Set<Integer> s2) {
    for (final int i : s1) {
      if (s2.contains(i)) {
        return true;
      }
    }
    return false;
  }

  static List<Set<Integer>> getCombination(final int[] bricks, final int w) {
    final List<Set<Integer>> result = new ArrayList<>();
    getCombination(result, bricks, w, new HashSet<>(), 0);
    return result;
  }

  private static void getCombination(final List<Set<Integer>> result, final int[] bricks,
                                     final int w, final Set<Integer> sums, final int sum) {
    for (final int brick : bricks) {
      final int next = brick + sum;
      if (next > w) return;
      if (next == w) result.add(new HashSet<>(sums));
      sums.add(next);
      getCombination(result, bricks, w, sums, next);
      sums.remove(next);
    }
  }
}
