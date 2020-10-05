package byteDance._465_Optimal_Account_Balancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minTransfers(int[][] transactions) {
    final Map<Integer, Integer> balances = new HashMap<>();
    for (final int[] t : transactions) {
      final int from = t[0], to = t[1], a = t[2];
      balances.put(from, balances.getOrDefault(from, 0) + a);
      balances.put(to, balances.getOrDefault(to, 0) - a);
    }
    final List<Integer> remains = new ArrayList<>();
    for (final Map.Entry<Integer, Integer> e : balances.entrySet()) {
      final int amount = e.getValue();
      if (amount != 0) {
        remains.add(amount);
      }
    }
    return dfs(remains, 0);
  }

  private final Map<List<Integer>, Integer> cache = new HashMap<>();

  private int dfs(final List<Integer> remains, int start) {
    while (start < remains.size() && remains.get(start) == 0) {
      start++;
    }
    if (start == remains.size()) {
      return 0;
    }
    final List<Integer> key = new ArrayList<>(remains);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    int min = Integer.MAX_VALUE;
    final int startVal = remains.get(start);
    for (int i = start; i < remains.size(); ++i) {
      if (remains.get(i) == 0) continue;
      final int iVal = remains.get(i);
      if ((startVal < 0) ^ (iVal < 0)) {
        final int sum = startVal + iVal;
        remains.set(start, 0);
        remains.set(i, sum);
        final int cur = 1 + dfs(remains, start + 1);
        min = Math.min(cur, min);
        remains.set(start, startVal);
        remains.set(i, iVal);
      }
    }
    assert min != Integer.MAX_VALUE;
    cache.put(key, min);
    return min;
  }
}
