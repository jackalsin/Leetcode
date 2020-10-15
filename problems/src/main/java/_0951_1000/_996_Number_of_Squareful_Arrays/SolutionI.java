package _0951_1000._996_Number_of_Squareful_Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/13/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Set<Integer>> squarePairs = new HashMap<>();
  private final Map<Integer, Integer> countMap = new HashMap<>();

  public int numSquarefulPerms(int[] A) {
    if (A == null) return 0;
    Arrays.sort(A);
    init(A);
    int res = 0;
    for (final int key : squarePairs.keySet()) {
      res += numSquarefulPerms(key, A.length - 1);
    }
    return res;
  }

  private int numSquarefulPerms(final int prev, final int left) {
    if (left == 0) {
      return 1;
    }
    countMap.put(prev, countMap.get(prev) - 1);
    int res = 0;
    for (int next : squarePairs.getOrDefault(prev, new HashSet<>())) {
      if (countMap.get(next) == 0) continue;
      res += numSquarefulPerms(next, left - 1);
    }
    countMap.put(prev, countMap.get(prev) + 1);
    return res;
  }

  private void init(final int[] a) {
    final int n = a.length;
    for (int i = 0; i < n; ++i) {
      countMap.put(a[i], countMap.getOrDefault(a[i], 0) + 1);
      for (int j = i + 1; j < n; ++j) {
        if (isSquare(a[i] + a[j])) {
          squarePairs.computeIfAbsent(a[i], k -> new HashSet<>()).add(a[j]);
          squarePairs.computeIfAbsent(a[j], k -> new HashSet<>()).add(a[i]);
        }
      }
    }
  }

  private static boolean isSquare(int val) {
    int left = 0, right = val;
    while (left <= right) {
      final long mid = left + (right - left) / 2,
          prod = mid * mid;
      if (prod == val) return true;
      else if (prod < val) {
        left = (int) (mid + 1);
      } else {
        right = (int) (mid - 1);
      }
    }
    return false;
  }
}
