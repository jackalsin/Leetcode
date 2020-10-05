package google._465_Optimal_Account_Balancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/29/2020
 */
public final class SolutionII implements Solution {
  private final Map<List<Integer>, Integer> cache = new HashMap<>();

  public int minTransfers(int[][] transactions) {
    final Map<Integer, Integer> balance = new HashMap<>();
    for (final int[] transaction : transactions) {
      final int from = transaction[0], to = transaction[1], amount = transaction[2];
      balance.put(from, balance.getOrDefault(from, 0) + amount);
      balance.put(to, balance.getOrDefault(to, 0) - amount);
    }
    final List<Integer> balances = new ArrayList<>();
    for (final Map.Entry<Integer, Integer> e : balance.entrySet()) {
      final int count = e.getValue();
      if (count != 0) {
        balances.add(count);
      }
    }
    return dfs(balances, 0);
  }

  private int dfs(final List<Integer> remain, int start) {
    while (start < remain.size() && remain.get(start) == 0) start++;
    if (start == remain.size()) {
      return 0;
    }
    if (cache.containsKey(remain)) {
      return cache.get(remain);
    }
    final List<Integer> key = new ArrayList<>(remain);
    final int startVal = remain.get(start);
    int min = remain.size();
    for (int i = start; i < remain.size(); ++i) {
      final int iVal = remain.get(i);
      if (iVal == 0) continue;
      if ((startVal < 0) ^ (iVal < 0)) {
        final int sum = startVal + iVal;
        if (sum > 0) {
          remain.set(start, sum);
          remain.set(i, 0);
          final int cur = 1 + dfs(remain, start);
          min = Math.min(cur, min);
        } else if (sum == 0) {
          remain.set(start, 0);
          remain.set(i, 0);
          final int cur = 1 + dfs(remain, start + 1);
          min = Math.min(cur, min);
        } else {
          remain.set(start, 0);
          remain.set(i, sum);
          final int cur = 1 + dfs(remain, start + 1);
          min = Math.min(cur, min);
        }
        remain.set(start, startVal);
        remain.set(i, iVal);
      }
    }
    assert min != remain.size();
    cache.put(key, min);
    return min;
  }
}
