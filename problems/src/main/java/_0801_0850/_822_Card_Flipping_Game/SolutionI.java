package _0801_0850._822_Card_Flipping_Game;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int flipgame(int[] fronts, int[] backs) {
    final Set<Integer> same = new HashSet<>();
    final int n = fronts.length;
    for (int i = 0; i < n; ++i) {
      if (fronts[i] == backs[i]) {
        same.add(fronts[i]);
      }
    }
    int res = Integer.MAX_VALUE;
    for (int f : fronts) {
      if (!same.contains(f)) {
        res = Math.min(res, f);
      }
    }
    for (int b : backs) {
      if (!same.contains(b)) {
        res = Math.min(res, b);
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
