package interviews.linkedin._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public class Solution {
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    Map<Integer, Boolean> cache = new HashMap<>();
    return canIWin(maxChoosableInteger, desiredTotal, cache);
  }

  private boolean canIWin(int maxChoosableInteger, int remain, Map<Integer, Boolean> cache) {
    if (remain < 0) {
      return true;
    }
    if (cache.containsKey(remain)) {
      return cache.get(remain);
    }
    for (int i = 1; i <= maxChoosableInteger; i++) {
      if (!canIWin(maxChoosableInteger, remain - i, cache)) {
        // lose
        cache.put(remain, true);
      }
    }
    return cache.getOrDefault(remain, false);
  }
}
