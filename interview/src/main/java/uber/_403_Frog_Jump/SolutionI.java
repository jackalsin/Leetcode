package uber._403_Frog_Jump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
public final class SolutionI implements Solution {
  private final Map<Long, Boolean> cache = new HashMap<>();

  public boolean canCross(int[] stones) {
    if (stones == null || stones.length == 0) return true;
    final Set<Integer> set = new HashSet<>();
    final int len = stones.length;
    for (int i = 0; i < stones.length; i++) {
      final int s = stones[i];
      if (i > 3 && stones[i - 1] * 2 < stones[i]) {
        return false;
      }
      set.add(s);
    }
    return dfs(set, stones[len - 1], 1, 1);
  }

  private boolean dfs(final Set<Integer> set, final int target, final int cur, final int k) {
    if (cur > target) return false;
    if (cur == target) return true;
    final long key = ((long) cur) << 32 | k;
    if (cache.containsKey(key)) return cache.get(key);
    if (!set.contains(cur)) {
      cache.put(key, false);
      return false;
    }
    boolean res = false;
    final int[] nextSteps = {k - 1, k, k + 1};
    for (final int step : nextSteps) {
      if (step <= 0) continue;
      final int next = step + cur;
      res = dfs(set, target, next, step);
      if (res) break;
    }
    cache.put(key, res);
    return res;
  }
}
