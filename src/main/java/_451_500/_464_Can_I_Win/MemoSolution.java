package _451_500._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/14/2017.
 */
public class MemoSolution implements Solution {
  private boolean[] used;
  private Map<Integer, Boolean> visited;

  @Override
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (desiredTotal <= 0) {
      return true;
    }
    /* if we don't check this one, the */
    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
      return false;
    }
    used = new boolean[maxChoosableInteger + 1];
    visited = new HashMap<>();
    return isCurrentPlayerWin(desiredTotal);
  }

  private boolean isCurrentPlayerWin(int remaining) {
    if (remaining <= 0) {
      return false;
    }
    int gameStatus = getGameStatus(used), maxChoosableInteger = used.length - 1;
    if (visited.containsKey(gameStatus)) {
      return visited.get(gameStatus);
    }
    for (int i = 1; i <= maxChoosableInteger; ++i) {
      if (!used[i]) {
        used[i] = true;
        boolean result = isCurrentPlayerWin(remaining - i);
        used[i] = false;
        if (!result) {
          visited.put(gameStatus, true);
          return true;
        }
      }
    }
    visited.put(gameStatus, false);
    return false;
  }

  private int getGameStatus(final boolean[] used) {
    int res = 0;
    for (boolean u : used) {
      res <<= 1;
      if (u) {
        res |= 1;
      }
    }
    return res;
  }
}
