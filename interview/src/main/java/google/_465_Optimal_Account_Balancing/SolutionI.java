package google._465_Optimal_Account_Balancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
 */
public final class SolutionI implements Solution {
  private final Map<List<Long>, Integer> cache = new HashMap<>();

  public int minTransfers(int[][] transactions) {
    final Map<Integer, Integer> idToBal = new HashMap<>();
    for (final int[] transaction : transactions) {
      idToBal.put(transaction[0], idToBal.getOrDefault(transaction[0], 0) - transaction[2]);
      idToBal.put(transaction[1], idToBal.getOrDefault(transaction[1], 0) + transaction[2]);
    }
    final List<Long> balances = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : idToBal.entrySet()) {
      if (entry.getValue() != 0) {
        balances.add((long) entry.getValue());
      }
    }
    return dfs(balances, 0);
  }

  private int dfs(List<Long> balances, int start) {
    while (start < balances.size() && balances.get(start) == 0) {
      start++;
    }
    if (start == balances.size()) {
      return 0;
    }
    if (cache.containsKey(balances)) {
      return cache.get(balances);
    }
    long res = Integer.MAX_VALUE;
    final long startVal = balances.get(start);
    balances.set(start, 0L);
    for (int i = start + 1; i < balances.size(); i++) {
      if (startVal * balances.get(i) < 0) {
        balances.set(i, balances.get(i) + startVal);
        res = Math.min(res, dfs(balances, start + 1) + 1L);
        balances.set(i, balances.get(i) - startVal);
      }
    }
    balances.set(start, startVal);
    cache.put(balances, (int) res);
    return (int) res;
  }

}
