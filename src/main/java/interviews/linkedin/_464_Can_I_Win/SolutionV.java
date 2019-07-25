package interviews.linkedin._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/24/2019
 */
public final class SolutionV implements Solution {
  private final Map<Integer, Boolean> stateToResult = new HashMap<>();

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
      return false;
    }
    if (desiredTotal == 0) {
      return true;
    }
    final boolean[] used = new boolean[maxChoosableInteger + 1];
    return canIWin(used, desiredTotal);
  }

  private boolean canIWin(final boolean[] used, final int desiredTotal) {
    if (desiredTotal <= 0) {
      return false;
    }
    final int state = getState(used);
    if (stateToResult.containsKey(state)) {
      return stateToResult.get(state);
    }

    for (int i = 1; i < used.length; i++) {
      if (used[i]) continue;
      used[i] = true;
      final boolean res = canIWin(used, desiredTotal - i);
      if (!res) { // 只要有一个fail，就挑它
        used[i] = false;
        stateToResult.put(state, true);
        return true;
      }
      used[i] = false;
    }
    stateToResult.put(state, false);
    return false;
  }


  private int getState(final boolean[] used) {
    int res = 0;
    for (boolean b : used) {
      res = ((res << 1) | (b ? 1 : 0));
    }
    return res;
  }

}
