package interviews.uber._465_Optimal_Account_Balancing;

import java.util.ArrayList;
import java.util.List;

public final class Solution {
  public int minTransfers(int[][] transactions) {

    int max = 0;
    for (final int[] t : transactions) {
      final int from = t[0], to = t[1];
      max = Math.max(from, max);
      max = Math.max(to, max);
    }

    final long[] idToBalance = new long[max + 1];
    for (final int[] t : transactions) {
      final int from = t[0], to = t[1], amount = t[2];
      idToBalance[from] -= amount;
      idToBalance[to] += amount;
    }
    final List<Long> balances = new ArrayList<>();
    for (final long bal : idToBalance) {
      if (bal != 0) {
        balances.add(bal);
      }
    }

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
