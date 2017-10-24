package interviews.linkedin._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public class Solution {
  private Map<Integer, Boolean> cache;
  private boolean[] visited;

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    final int maxSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
    if (maxSum < desiredTotal) {
      return false;
    }
    if (desiredTotal <= 0) {
      return true;
    }
    cache = new HashMap<>();
    visited = new boolean[maxChoosableInteger + 1];
    return canIWin(desiredTotal);
  }

  private boolean canIWin(int remain) {
    if (remain <= 0) {
      return false;
    }
    final int maxChoosableInteger = visited.length - 1;
    int status = getStatus();
    if (cache.containsKey(status)) {
      return cache.get(status);
    }
    for (int i = 1; i <= maxChoosableInteger; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (!canIWin(remain - i)) { // lose
          cache.put(status, true);
          visited[i] = false;
          return true; // once true, mean has a solution to win.
        }
        visited[i] = false;
      }
    }
    cache.put(status, false);
    return false;
  }

  private int getStatus() {
    int res = 0;
    for (int i = 1; i < visited.length; i++) {
      res |= visited[i] ? 1 : 0;
      res <<= 1;
    }
    return res;
  }
}
