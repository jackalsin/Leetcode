package google.majiang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/7/2021
 */
public final class SolutionI implements Solution {
  private final Map<Long, Boolean> cache = new HashMap<>();

  public boolean canWin(List<Integer> tiles) {
    assert tiles != null;
    assert tiles.size() == 14;
    final int[] counts = new int[10];
    for (final int t : tiles) {
      counts[t]++;
    }
    return dfs(counts, 0, 14);
  }

  private boolean dfs(final int[] counts, final int start, final int remain) {
    final long key = getKey(counts);
    if (cache.containsKey(key)) return cache.get(key);
    if (remain == 2) {
      for (int c : counts) {
        if (c == 2) {
          cache.put(key, true);
          return true;
        }
      }
      cache.put(key, false);
      return false;
    }
    for (int i = start; i < counts.length; ++i) {
      if (counts[i] >= 3) {
        counts[i] -= 3;
        final boolean prev = dfs(counts, i, remain - 3);
        if (prev) {
          cache.put(key, true);
          counts[i] += 3;
          return true;
        }
        counts[i] += 3;
      }
      if (i + 2 < counts.length && counts[i] >= 1 && counts[i + 1] >= 1 && counts[i + 2] >= 1) {
        counts[i]--;
        counts[i + 1]--;
        counts[i + 2]--;
        final boolean prev = dfs(counts, start, remain - 3);
        counts[i + 2]++;
        counts[i + 1]++;
        counts[i]++;
        if (prev) {
          cache.put(key, true);
          return true;
        }
      }
    }
    cache.put(key, false);
    return false;
  }

  private static long getKey(final int[] counts) {
    long res = 0;
    for (int c : counts) {
      res = res << 4 | c;
    }
    return res;
  }

}
