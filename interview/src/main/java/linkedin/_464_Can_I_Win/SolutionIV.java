package linkedin._464_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIV implements Solution {
  private static final int MAX_CHOOSABLE = 20;
//  private final boolean[] used = new boolean[MAX_CHOOSABLE + 1];

  @Override
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    final int maxSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
    if (maxSum < desiredTotal) {
      return false;
    }
    final Map<Integer, Boolean> cache = new HashMap<>();
    if (desiredTotal == 0) {
      return true;
    }
    return canIWin(cache, maxChoosableInteger, desiredTotal, 0);
  }

  private static boolean canIWin(final Map<Integer, Boolean> cache, final int maxChoosableInteger,
                                 final int remain, int curPath) {
    if (remain <= 0) {
      return false;
    }

    if (cache.containsKey(curPath)) {
      return cache.get(curPath);
    }
    for (int i = 1; i <= maxChoosableInteger; ++i) {
      if (((curPath >> i) & 1) == 1) {
        continue;
      }

      final boolean res = canIWin(cache, maxChoosableInteger, remain - i, curPath | (1 << i));
      if (!res) {
        cache.put(curPath, true);
        return true;
      }
    }
    cache.put(curPath, false);

    return false;
  }
}
