package _1051_1100._1088_Confusing_Number_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/26/2020
 */
public final class SolutionI implements Solution {
  private static final Map<Integer, Integer> MAP = new HashMap<>() {{
    put(0, 0);
    put(1, 1);
    put(6, 9);
    put(8, 8);
    put(9, 6);
  }};
  private int res = 0;

  public int confusingNumberII(int N) {
    dfs(1, 1, N, 10);
    dfs(6, 9, N, 10);
    dfs(8, 8, N, 10);
    dfs(9, 6, N, 10);
    return res;
  }

  private void dfs(final long src, long rotate, final int N, final int times) {
    if (src > N) return;
    if (src != rotate) {
      res++;
    }
    for (final Map.Entry<Integer, Integer> e : MAP.entrySet()) {
      final int d = e.getKey(), r = e.getValue();
      dfs(src * 10 + d, r * times + rotate, N, times * 10);
    }
  }
}
