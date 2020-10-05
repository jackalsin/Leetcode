package _0451_0500._465_Optimal_Account_Balancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 75 ms Solution
 */
public class Solution {
  public int minTransfers(int[][] transactions) {
    final Map<Integer, Integer> bal = new HashMap<>();
    for (final int[] trans : transactions) {
      bal.put(trans[0], bal.getOrDefault(trans[0], 0) - trans[2]);
      bal.put(trans[1], bal.getOrDefault(trans[1], 0) + trans[2]);
    }

    final List<Integer> debt = new ArrayList<>();

    for (Map.Entry<Integer, Integer> entry : bal.entrySet()) {
      if (entry.getValue() != 0) {
        debt.add(entry.getValue());
      }
    }

    return dfs(debt, 0, 0);
  }

  int dfs(final List<Integer> debt, int start, int cnt) {
    long result = Integer.MAX_VALUE;
    while (start < debt.size() && debt.get(start) == 0) start++;
    for (int i = start + 1, prev = 0; i < debt.size(); i++) {
      if (debt.get(start) * debt.get(i) < 0) {
        debt.set(i, debt.get(i) + debt.get(start));
        result = Math.min(result, dfs(debt, start + 1, cnt + 1));
        debt.set(i, debt.get(i) - debt.get(start));
        prev = debt.get(i);
      }
    }
    return result == Integer.MAX_VALUE ? cnt : (int) result;
  }
}
