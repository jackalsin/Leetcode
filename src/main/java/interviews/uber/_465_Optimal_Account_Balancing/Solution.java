package interviews.uber._465_Optimal_Account_Balancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Solution {
  public int minTransfers(int[][] transactions) {
    final Map<Integer, Long> idToBalance = new HashMap<>();
    for (final int[] t : transactions) {
      final int from = t[0], to = t[1], amount = t[2];
      idToBalance.put(from, idToBalance.getOrDefault(from, 0L) - amount);
      idToBalance.put(to, idToBalance.getOrDefault(to, 0L) + amount);
    }
    final List<Long> balances = new ArrayList<>();
    for (final Map.Entry<Integer, Long> e : idToBalance.entrySet()) {
      final long bal = e.getValue();
      if (bal != 0) {
        balances.add(bal);
      }
    }

//    System.out.println(balances);
    return dfs(balances, 0);
  }

  private static int dfs(final List<Long> balances, int start) {
    while (start < balances.size() && balances.get(start) == 0) {
      start++; // go next non zero;
    }
    int res = Integer.MAX_VALUE;
    for (int i = start + 1; i < balances.size(); i++) {
      if (balances.get(i) * balances.get(start) < 0) {
        balances.set(i, balances.get(i) + balances.get(start));
        res = Math.min(res, 1 + dfs(balances, start + 1));
        balances.set(i, balances.get(i) - balances.get(start));
      }
    }

    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
