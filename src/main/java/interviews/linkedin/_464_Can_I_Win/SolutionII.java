package interviews.linkedin._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionII implements Solution {

  private final Map<Integer, Boolean> cache = new HashMap<>();
  private final boolean[] usedInteger = new boolean[21];

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    int maxSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
    if (desiredTotal <= 0) {
      return true;
    }
    if (desiredTotal > maxSum) {
      return false;
    }
    return canIWinHelper(maxChoosableInteger, desiredTotal);
  }

  private boolean canIWinHelper(int maxChoosableInteger, int desiredTotal) {
    if (desiredTotal <= 0) {
      return false;
    }
    // Remind: the reason we don't use desiredTotal is that, it doesn't represent the visited the right status
    final int desiredState = getState();
    if (cache.containsKey(desiredState)) {
      return cache.get(desiredState);
    }

    boolean canIWin = false;
    for (int i = 1; i <= maxChoosableInteger; i++) {
      if (usedInteger[i]) continue;
      usedInteger[i] = true;
      if (!canIWinHelper(maxChoosableInteger, desiredTotal - i)) {
        canIWin = true;
        usedInteger[i] = false;
        break;
      }
      usedInteger[i] = false;
    }
    cache.put(desiredState, canIWin);
    return canIWin;
  }

  private int getState() {
    int res = 0;
    for (int i = 1; i < usedInteger.length; i++) {
      res <<= 1;
      res |= usedInteger[i] ? 1 : 0;
    }
    return res;
  }
}
