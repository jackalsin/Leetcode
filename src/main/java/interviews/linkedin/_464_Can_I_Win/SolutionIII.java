package interviews.linkedin._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIII implements Solution {
  private static final int MAX_CHOOSABLE = 20;
//  private final boolean[] used = new boolean[MAX_CHOOSABLE + 1];

  @Override
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if ((1 + maxChoosableInteger) * maxChoosableInteger < desiredTotal) {
      return false;
    }

    if (desiredTotal <= 0) {
      return true;
    }
    final Map<Integer, Boolean> cache = new HashMap<>();
    final boolean result = dfs(cache, maxChoosableInteger, desiredTotal, 0);
    return result;
  }

  private static boolean dfs(final Map<Integer, Boolean> cache, final int maxChoosableInteger,
                             final int remain, final int curPath) {
    if (remain <= 0) { // exceeds also win
      return false;
    }

    if (cache.containsKey(curPath)) {
      return cache.get(curPath);
    }

    for (int i = 1; i <= maxChoosableInteger; ++i) {
      if (((curPath >> i) & 1) == 1) {
        continue;
      }
      if (!dfs(cache, maxChoosableInteger, remain - i, curPath | (1 << i))) {
        cache.put(curPath, true);
        return true;
      }
    }
    cache.put(curPath, false);
    return false;
  }
}
