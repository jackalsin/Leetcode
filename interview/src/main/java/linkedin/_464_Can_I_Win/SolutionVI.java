package linkedin._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/8/2019
 */
public final class SolutionVI implements Solution {
  private final Map<Integer, Boolean> cache = new HashMap<>();

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (desiredTotal < 0) {
      return false;
    }
    if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
      return false;
    }
    if (desiredTotal == 0) {
      return true;
    }
    return canIWinHelper(desiredTotal, new boolean[maxChoosableInteger + 1]);
  }

  private boolean canIWinHelper(final int remain, final boolean[] used) {
    if (remain <= 0) {
      return false;
    }
    final int state = getState(used);
    if (cache.containsKey(state)) {
      return cache.get(state);
    }
    for (int i = 1; i < used.length; ++i) {
      if (used[i]) continue;
      used[i] = true;
      final boolean res = canIWinHelper(remain - i, used);
      if (!res) { //只要输一次，我就赢了
        cache.put(state, true);
        used[i] = false;
        return true;
      }
      used[i] = false;
    }
    cache.put(state, false);
    return false;
  }

  private static int getState(final boolean[] used) {
    int res = 0;
    for (boolean b : used) {
      res = (res << 1) | (b ? 1 : 0);
    }
    return res;
  }
}
